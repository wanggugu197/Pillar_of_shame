package org.gte.gtecore.api.recipe;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.api.machine.trait.IEnhancedRecipeLogic;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Set;
import java.util.concurrent.*;

public final class AsyncRecipeOutputTask {

    private final Set<Runnable> runnables = ConcurrentHashMap.newKeySet();

    private boolean hasRequest, inQueue;

    private static final CopyOnWriteArraySet<AsyncRecipeOutputTask> tasks = new CopyOnWriteArraySet<>();
    private static ScheduledExecutorService executorService;
    private final static ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder()
            .setNameFormat("Recipe Output Thread-%d")
            .setDaemon(true)
            .build();

    private AsyncRecipeOutputTask() {}

    private static void createExecutorService() {
        if (executorService != null && !executorService.isShutdown()) return;
        executorService = Executors.newSingleThreadScheduledExecutor(THREAD_FACTORY);
        executorService.scheduleAtFixedRate(AsyncRecipeOutputTask::outputTask, 0, 50, TimeUnit.MILLISECONDS);
    }

    public static void addAsyncLogic(RecipeLogic logic, Runnable runnable) {
        if (logic instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
            AsyncRecipeOutputTask task = enhancedRecipeLogic.gtecore$getAsyncRecipeOutputTask();
            if (task == null) {
                task = new AsyncRecipeOutputTask();
                enhancedRecipeLogic.gtecore$setAsyncRecipeOutputTask(task);
            }
            task.runnables.add(runnable);
            task.hasRequest = true;
            if (task.inQueue) return;
            tasks.add(task);
            task.inQueue = true;
            createExecutorService();
        }
    }

    public static void removeAsyncLogic(RecipeLogic logic) {
        if (logic instanceof IEnhancedRecipeLogic enhancedRecipeLogic) {
            AsyncRecipeOutputTask task = enhancedRecipeLogic.gtecore$getAsyncRecipeOutputTask();
            if (task == null) return;
            enhancedRecipeLogic.gtecore$setAsyncRecipeOutputTask(null);
            if (task.inQueue && tasks.remove(task)) {
                task.hasRequest = false;
                task.inQueue = false;
                task.runnables.clear();
                if (tasks.isEmpty()) {
                    releaseExecutorService();
                }
            }
        }
    }

    private static void outputTask() {
        try {
            if (!GTCEu.canGetServerLevel()) return;
            for (var task : tasks) {
                if (task.hasRequest) {
                    try {
                        task.hasRequest = false;
                        for (Runnable runnable : task.runnables) {
                            runnable.run();
                        }
                    } catch (Throwable e) {
                        GTECore.LOGGER.error("Error while output recipe");
                        e.printStackTrace();
                    }
                    task.runnables.clear();
                }
            }
        } catch (Throwable ignored) {}
    }

    public static void releaseExecutorService() {
        tasks.clear();
        if (executorService != null) {
            executorService.shutdownNow();
        }
        executorService = null;
    }
}
