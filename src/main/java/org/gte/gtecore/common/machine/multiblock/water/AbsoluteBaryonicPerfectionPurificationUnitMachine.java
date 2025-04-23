package org.gte.gtecore.common.machine.multiblock.water;

import org.gte.gtecore.api.recipe.GTERecipeBuilder;
import org.gte.gtecore.api.recipe.RecipeRunnerHelper;
import org.gte.gtecore.common.data.GTEItems;
import org.gte.gtecore.common.data.GTEMaterials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AbsoluteBaryonicPerfectionPurificationUnitMachine extends WaterPurificationUnitMachine {

    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            AbsoluteBaryonicPerfectionPurificationUnitMachine.class, WaterPurificationUnitMachine.MANAGED_FIELD_HOLDER);

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private static final List<Item> CATALYST = List.of(
            GTEItems.UP_QUARK_RELEASING_CATALYST.get(),
            GTEItems.DOWN_QUARK_RELEASING_CATALYST.get(),
            GTEItems.BOTTOM_QUARK_RELEASING_CATALYST.get(),
            GTEItems.TOP_QUARK_RELEASING_CATALYST.get(),
            GTEItems.STRANGE_QUARK_RELEASING_CATALYST.get(),
            GTEItems.CHARM_QUARK_RELEASING_CATALYST.get());

    private static final Fluid QUARK_GLUON = GTEMaterials.QuarkGluon.getFluid(FluidStorageKeys.PLASMA);
    private static final Fluid STABLE_BARYONIC_MATTER = GTEMaterials.StableBaryonicMatter.getFluid();

    @Persisted
    @DescSynced
    private Item catalyst1;
    @Persisted
    @DescSynced
    private Item catalyst2;

    @Persisted
    private int inputCount;

    @Persisted
    private boolean successful;

    @Persisted
    private final List<ItemStack> outputs = new ObjectArrayList<>();

    private final List<ItemBusPartMachine> busMachines = new ObjectArrayList<>();

    public AbsoluteBaryonicPerfectionPurificationUnitMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void customText(List<Component> textList) {
        super.customText(textList);
        if (getRecipeLogic().isWorking()) {
            textList.add(Component.translatable("gtecore.machine.absolute_baryonic_perfection_purification_unit.items", catalyst1.getDescription(), catalyst2.getDescription()));
            textList.add(Component.translatable("gui.enderio.sag_mill_chance", successful ? 100 : 0));
        }
    }

    @Override
    public void onPartScan(IMultiPart part) {
        super.onPartScan(part);
        if (part instanceof ItemBusPartMachine itemBusPart) {
            IO io = itemBusPart.getInventory().getHandlerIO();
            if (io == IO.IN || io == IO.BOTH) {
                busMachines.add(itemBusPart);
            }
        }
    }

    @Override
    public void onStructureFormed() {
        busMachines.clear();
        super.onStructureFormed();
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        busMachines.clear();
    }

    @Override
    public boolean onWorking() {
        if (!super.onWorking()) return false;
        if (getOffsetTimer() % 20 == 0) {
            boolean successful = false;
            for (ItemBusPartMachine bus : busMachines) {
                NotifiableItemStackHandler inv = bus.getInventory();
                int slots = inv.getSlots();
                for (int i = 0; i < slots; i++) {
                    ItemStack stack = inv.getStackInSlot(i);
                    if (CATALYST.contains(stack.getItem()) && inputFluid(QUARK_GLUON, stack.getCount() * 144)) {
                        if (i < slots - 1 && stack.getItem() == catalyst1) {
                            ItemStack stack1 = inv.getStackInSlot(i + 1);
                            if (!stack1.isEmpty() && inputFluid(QUARK_GLUON, stack1.getCount() * 144)) {
                                if (stack1.getItem() == catalyst2) {
                                    outputFluid(STABLE_BARYONIC_MATTER, 1000);
                                    successful = true;
                                    this.successful = true;
                                }
                                inv.setStackInSlot(i + 1, ItemStack.EMPTY);
                                if (!successful) outputs.add(stack1);
                            }
                        }
                        if (!successful) outputs.add(stack);
                        inv.setStackInSlot(i, ItemStack.EMPTY);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void onRecipeFinish() {
        super.onRecipeFinish();
        outputs.forEach(this::outputItem);
        outputs.clear();
        if (successful) outputFluid(WaterPurificationPlantMachine.GradePurifiedWater8, inputCount * 9 / 10);
    }

    @Override
    long before() {
        eut = 0;
        successful = false;
        inputCount = Math.min(getParallel(), getFluidAmount(WaterPurificationPlantMachine.GradePurifiedWater7)[0]);
        recipe = GTERecipeBuilder.ofRaw().duration(WaterPurificationPlantMachine.DURATION).inputFluids(new FluidStack(WaterPurificationPlantMachine.GradePurifiedWater7, inputCount)).buildRawRecipe();
        if (RecipeRunnerHelper.matchRecipe(this, recipe)) {
            int a = GTValues.RNG.nextInt(5);
            int b;
            do {
                b = GTValues.RNG.nextInt(5);
            } while (b == a);
            catalyst1 = CATALYST.get(a);
            catalyst2 = CATALYST.get(b);
            eut = (long) inputCount << 6;
        }
        return eut;
    }
}
