package org.gte.gtecore.common.machine.multiblock.electric.adventure;

import org.gte.gtecore.api.item.ItemStackSet;
import org.gte.gtecore.api.machine.multiblock.StorageMultiblockMachine;
import org.gte.gtecore.api.machine.trait.CustomRecipeLogic;
import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.utils.MachineUtils;
import org.gte.gtecore.utils.StringUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeHandlerList;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;

import appeng.util.Platform;
import com.enderio.machines.common.init.MachineBlocks;
import com.lowdragmc.lowdraglib.gui.util.ClickData;
import com.lowdragmc.lowdraglib.gui.widget.ComponentPanelWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class SlaughterhouseMachine extends StorageMultiblockMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            SlaughterhouseMachine.class, StorageMultiblockMachine.MANAGED_FIELD_HOLDER);

    private int attackDamage;
    @Persisted
    private boolean isSpawn;
    private DamageSource damageSource;
    private static final String[] mobList1 = {
            "minecraft:chicken",
            "minecraft:rabbit",
            "minecraft:sheep",
            "minecraft:cow",
            "minecraft:horse",
            "minecraft:pig",
            "minecraft:donkey",
            "minecraft:skeleton_horse",
            "minecraft:iron_golem",
            "minecraft:wolf",
            "minecraft:goat",
            "minecraft:parrot",
            "minecraft:camel",
            "minecraft:cat",
            "minecraft:fox",
            "minecraft:llama",
            "minecraft:panda",
            "minecraft:polar_bear"
    };

    private static final String[] mobList2 = {
            "minecraft:ghast",
            "minecraft:zombie",
            "minecraft:pillager",
            "minecraft:zombie_villager",
            "minecraft:skeleton",
            "minecraft:drowned",
            "minecraft:witch",
            "minecraft:spider",
            "minecraft:creeper",
            "minecraft:husk",
            "minecraft:wither_skeleton",
            "minecraft:blaze",
            "minecraft:zombified_piglin",
            "minecraft:slime",
            "minecraft:vindicator",
            "minecraft:enderman"
    };

    public SlaughterhouseMachine(IMachineBlockEntity holder) {
        super(holder, 1, i -> i.is(MachineBlocks.POWERED_SPAWNER.asItem()));
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private static Player getFakePlayer(ServerLevel level) {
        return Platform.getFakePlayer(level, null);
    }

    private DamageSource getDamageSource(ServerLevel level) {
        if (damageSource == null) {
            damageSource = new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL), getFakePlayer(level));
        }
        return damageSource;
    }

    @Override
    public void onContentChanges(RecipeHandlerList handlerList) {
        if (handlerList.getHandlerIO() == IO.IN) {
            attackDamage = 1;
            forEachInputItems(itemStack -> {
                if (itemStack.getItem() instanceof SwordItem swordItem) {
                    attackDamage += (int) swordItem.getDamage();
                }
                return false;
            });
        }
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        textList.add(Component.translatable("item.gtceu.tool.tooltip.attack_damage", attackDamage));
        textList.add(Component.translatable("gtecore.machine.slaughterhouse.is_spawn").append(ComponentPanelWidget.withButton(Component.literal("[").append(isSpawn ? Component.translatable("gtecore.machine.on") : Component.translatable("gtecore.machine.off")).append(Component.literal("]")), "spawn_switch")));
    }

    @Override
    public void handleDisplayClick(String componentData, ClickData clickData) {
        if (!clickData.isRemote) {
            if ("spawn_switch".equals(componentData)) {
                isSpawn = !isSpawn;
            }
        }
    }

    @Nullable
    private GTRecipe getRecipe() {
        if (getLevel() instanceof ServerLevel serverLevel && getTier() > 1) {
            int c = checkingCircuit(false);
            if (c == 0) return null;
            ItemStackSet itemStacks = new ItemStackSet();
            BlockPos blockPos = MachineUtils.getOffsetPos(3, 1, getFrontFacing(), getPos());
            ItemStack itemStack = getStorageStack();
            boolean isFixed = !itemStack.isEmpty();
            String[] mobList = isFixed ? null : c == 1 ? mobList1 : mobList2;
            int tierMultiplier = (getTier() - 2) << 3;

            List<Entity> entities = serverLevel.getEntitiesOfClass(Entity.class, new AABB(
                    blockPos.getX() - 3,
                    blockPos.getY() - 1,
                    blockPos.getZ() - 3,
                    blockPos.getX() + 3,
                    blockPos.getY() + 6,
                    blockPos.getZ() + 3));

            for (Entity entity : entities) {
                if (entity instanceof LivingEntity) {
                    entity.hurt(getDamageSource(serverLevel), attackDamage);
                } else if (entity instanceof ItemEntity itemEntity) {
                    itemStacks.add(itemEntity.getItem());
                    itemEntity.discard();
                }
                entity.discard();
            }

            for (int i = 0; i <= tierMultiplier; i++) {
                String mob = isFixed ? itemStack.getOrCreateTag().getCompound("BlockEntityTag")
                        .getCompound("EntityStorage").getCompound("Entity").getString("id") : mobList[GTValues.RNG.nextInt(mobList.length)];
                Optional<EntityType<?>> entityType = EntityType.byString(mob);
                if (entityType.isEmpty()) continue;
                Entity entity = entityType.get().create(serverLevel);
                if (!(entity instanceof Mob mob1)) continue;
                if (isSpawn) {
                    mob1.setPos(blockPos.getCenter());
                    mob1.setNoAi(true);
                    serverLevel.addFreshEntity(mob1);
                } else {
                    String[] mobParts = StringUtils.decompose(mob);
                    if (mobParts.length < 2) continue;
                    LootTable lootTable = serverLevel.getServer().getLootData()
                            .getLootTable(new ResourceLocation(mobParts[0], "entities/" + mobParts[1]));
                    LootParams lootParams = new LootParams.Builder(serverLevel)
                            .withParameter(LootContextParams.LAST_DAMAGE_PLAYER, getFakePlayer(serverLevel))
                            .withParameter(LootContextParams.THIS_ENTITY, entity)
                            .withParameter(LootContextParams.DAMAGE_SOURCE, getDamageSource(serverLevel))
                            .withParameter(LootContextParams.ORIGIN, blockPos.getCenter())
                            .create(lootTable.getParamSet());

                    lootTable.getRandomItems(lootParams).forEach(stack -> itemStacks.add(isFixed ? stack.copyWithCount(tierMultiplier) : stack));
                    if (isFixed) break;
                }
            }
            GTERecipeBuilder builder = GTERecipeBuilder.ofRaw().duration(isSpawn ? 20 : Math.max(20, 20 * (1 << getTier()) - attackDamage)).EUt(getOverclockVoltage());
            itemStacks.forEach(builder::outputItems);
            GTRecipe recipe = builder.buildRawRecipe();
            if (RecipeRunnerHelper.matchRecipeTickInput(this, recipe)) return recipe;
        }
        return null;
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull... args) {
        return new CustomRecipeLogic(this, this::getRecipe);
    }
}
