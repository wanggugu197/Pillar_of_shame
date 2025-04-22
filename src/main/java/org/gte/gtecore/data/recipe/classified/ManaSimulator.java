package org.gte.gtecore.data.recipe.classified;

import org.gte.gtecore.GTECore;
import org.gte.gtecore.utils.RegistriesUtils;

import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import com.enderio.base.common.init.EIOFluids;

import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static net.minecraft.tags.ItemTags.LEAVES;
import static org.gte.gtecore.common.data.GTERecipeTypes.MANA_SIMULATOR_RECIPES;

public interface ManaSimulator {

    int BUFF_FACTOR = 8;

    static void init() {
        MANA_SIMULATOR_RECIPES.builder("thermalily")
                .notConsumable(RegistriesUtils.getItem("botania", "thermalily"))
                .inputFluids(new FluidStack(Fluids.LAVA, 1000))
                .duration(900)
                .EUt(VA[MV])
                .MANAt(-20 * BUFF_FACTOR)
                .save();

        MANA_SIMULATOR_RECIPES.recipeBuilder(GTECore.id("rosa_arcana"))
                .notConsumable(RegistriesUtils.getItem("botania", "rosa_arcana"))
                .inputFluids(new FluidStack(EIOFluids.XP_JUICE.get().getSource(), 1000))
                .EUt(VA[MV])
                .duration(1000)
                .MANAt(-50 * BUFF_FACTOR)
                .save();

        MANA_SIMULATOR_RECIPES.recipeBuilder(GTECore.id("munchdew"))
                .notConsumable(RegistriesUtils.getItem("botania", "munchdew"))
                .inputItems(LEAVES, 4)
                .EUt(VA[MV])
                .duration(20)
                .MANAt(-32 * BUFF_FACTOR)
                .save();
    }
}
