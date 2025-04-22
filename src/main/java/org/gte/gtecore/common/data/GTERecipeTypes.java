package org.gte.gtecore.common.data;

import org.gte.gtecore.api.gui.GTEGuiTextures;
import org.gte.gtecore.api.machine.trait.TierCasingTrait;
import org.gte.gtecore.api.recipe.GTERecipeType;
import org.gte.gtecore.api.recipe.JointRecipeType;
import org.gte.gtecore.common.machine.multiblock.part.InfiniteIntakeHatchPartMachine;
import org.gte.gtecore.common.machine.trait.RecyclerLogic;
import org.gte.gtecore.common.recipe.RecipeTypeModify;
import org.gte.gtecore.config.GTEConfig;
import org.gte.gtecore.data.recipe.generated.GenerateDisassembly;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.sound.ExistingSoundEntry;
import com.gregtechceu.gtceu.common.data.GCYMRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.gregtechceu.gtceu.utils.ResearchManager;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;

import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.utils.CycleItemStackHandler;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import java.util.ArrayList;
import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.LEFT_TO_RIGHT;
import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.UP_TO_DOWN;
import static org.gte.gtecore.api.GTEValues.*;
import static org.gte.gtecore.common.machine.multiblock.part.SpoolHatchPartMachine.SPOOL;
import static org.gte.gtecore.utils.register.RecipeTypeRegisterUtils.*;
import static org.gte.gtecore.utils.register.RecipeTypeRegisterUtils.register;

public interface GTERecipeTypes {

    static void init() {
        RecipeTypeModify.init();
    }

    GTERecipeType ALLOY_BLAST_RECIPES = (GTERecipeType) GCYMRecipeTypes.ALLOY_BLAST_RECIPES;
    GTERecipeType STEAM_BOILER_RECIPES = (GTERecipeType) GTRecipeTypes.STEAM_BOILER_RECIPES;
    GTERecipeType FURNACE_RECIPES = (GTERecipeType) GTRecipeTypes.FURNACE_RECIPES;
    GTERecipeType ALLOY_SMELTER_RECIPES = (GTERecipeType) GTRecipeTypes.ALLOY_SMELTER_RECIPES;
    GTERecipeType ARC_FURNACE_RECIPES = (GTERecipeType) GTRecipeTypes.ARC_FURNACE_RECIPES;
    GTERecipeType ASSEMBLER_RECIPES = (GTERecipeType) GTRecipeTypes.ASSEMBLER_RECIPES;
    GTERecipeType AUTOCLAVE_RECIPES = (GTERecipeType) GTRecipeTypes.AUTOCLAVE_RECIPES;
    GTERecipeType BENDER_RECIPES = (GTERecipeType) GTRecipeTypes.BENDER_RECIPES;
    GTERecipeType BREWING_RECIPES = (GTERecipeType) GTRecipeTypes.BREWING_RECIPES;
    GTERecipeType MACERATOR_RECIPES = (GTERecipeType) GTRecipeTypes.MACERATOR_RECIPES;
    GTERecipeType CANNER_RECIPES = (GTERecipeType) GTRecipeTypes.CANNER_RECIPES;
    GTERecipeType CENTRIFUGE_RECIPES = (GTERecipeType) GTRecipeTypes.CENTRIFUGE_RECIPES;
    GTERecipeType CHEMICAL_BATH_RECIPES = (GTERecipeType) GTRecipeTypes.CHEMICAL_BATH_RECIPES;
    GTERecipeType CHEMICAL_RECIPES = (GTERecipeType) GTRecipeTypes.CHEMICAL_RECIPES;
    GTERecipeType COMPRESSOR_RECIPES = (GTERecipeType) GTRecipeTypes.COMPRESSOR_RECIPES;
    GTERecipeType CUTTER_RECIPES = (GTERecipeType) GTRecipeTypes.CUTTER_RECIPES;
    GTERecipeType DISTILLERY_RECIPES = (GTERecipeType) GTRecipeTypes.DISTILLERY_RECIPES;
    GTERecipeType ELECTROLYZER_RECIPES = (GTERecipeType) GTRecipeTypes.ELECTROLYZER_RECIPES;
    GTERecipeType ELECTROMAGNETIC_SEPARATOR_RECIPES = (GTERecipeType) GTRecipeTypes.ELECTROMAGNETIC_SEPARATOR_RECIPES;
    GTERecipeType EXTRACTOR_RECIPES = (GTERecipeType) GTRecipeTypes.EXTRACTOR_RECIPES;
    GTERecipeType EXTRUDER_RECIPES = (GTERecipeType) GTRecipeTypes.EXTRUDER_RECIPES;
    GTERecipeType FERMENTING_RECIPES = (GTERecipeType) GTRecipeTypes.FERMENTING_RECIPES;
    GTERecipeType FLUID_HEATER_RECIPES = (GTERecipeType) GTRecipeTypes.FLUID_HEATER_RECIPES;
    GTERecipeType FLUID_SOLIDFICATION_RECIPES = (GTERecipeType) GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES;
    GTERecipeType FORGE_HAMMER_RECIPES = (GTERecipeType) GTRecipeTypes.FORGE_HAMMER_RECIPES;
    GTERecipeType FORMING_PRESS_RECIPES = (GTERecipeType) GTRecipeTypes.FORMING_PRESS_RECIPES;
    GTERecipeType LATHE_RECIPES = (GTERecipeType) GTRecipeTypes.LATHE_RECIPES;
    GTERecipeType MIXER_RECIPES = (GTERecipeType) GTRecipeTypes.MIXER_RECIPES;
    GTERecipeType ORE_WASHER_RECIPES = (GTERecipeType) GTRecipeTypes.ORE_WASHER_RECIPES;
    GTERecipeType PACKER_RECIPES = (GTERecipeType) GTRecipeTypes.PACKER_RECIPES.prepareBuilder(recipeBuilder -> recipeBuilder.EUt(7).duration(20));
    GTERecipeType POLARIZER_RECIPES = (GTERecipeType) GTRecipeTypes.POLARIZER_RECIPES;
    GTERecipeType LASER_ENGRAVER_RECIPES = (GTERecipeType) GTRecipeTypes.LASER_ENGRAVER_RECIPES;
    GTERecipeType SIFTER_RECIPES = (GTERecipeType) GTRecipeTypes.SIFTER_RECIPES;
    GTERecipeType THERMAL_CENTRIFUGE_RECIPES = (GTERecipeType) GTRecipeTypes.THERMAL_CENTRIFUGE_RECIPES;
    GTERecipeType WIREMILL_RECIPES = (GTERecipeType) GTRecipeTypes.WIREMILL_RECIPES;
    GTERecipeType CIRCUIT_ASSEMBLER_RECIPES = (GTERecipeType) GTRecipeTypes.CIRCUIT_ASSEMBLER_RECIPES;
    GTERecipeType GAS_COLLECTOR_RECIPES = (GTERecipeType) GTRecipeTypes.GAS_COLLECTOR_RECIPES.onRecipeBuild(InfiniteIntakeHatchPartMachine::init);
    GTERecipeType AIR_SCRUBBER_RECIPES = (GTERecipeType) GTRecipeTypes.AIR_SCRUBBER_RECIPES;
    GTERecipeType RESEARCH_STATION_RECIPES = (GTERecipeType) GTRecipeTypes.RESEARCH_STATION_RECIPES;
    GTERecipeType ROCK_BREAKER_RECIPES = (GTERecipeType) GTRecipeTypes.ROCK_BREAKER_RECIPES;
    GTERecipeType SCANNER_RECIPES = (GTERecipeType) GTRecipeTypes.SCANNER_RECIPES;
    GTERecipeType COMBUSTION_GENERATOR_FUELS = (GTERecipeType) GTRecipeTypes.COMBUSTION_GENERATOR_FUELS;
    GTERecipeType GAS_TURBINE_FUELS = (GTERecipeType) GTRecipeTypes.GAS_TURBINE_FUELS;
    GTERecipeType STEAM_TURBINE_FUELS = (GTERecipeType) GTRecipeTypes.STEAM_TURBINE_FUELS;
    GTERecipeType PLASMA_GENERATOR_FUELS = (GTERecipeType) GTRecipeTypes.PLASMA_GENERATOR_FUELS;
    GTERecipeType LARGE_BOILER_RECIPES = (GTERecipeType) GTRecipeTypes.LARGE_BOILER_RECIPES;
    GTERecipeType COKE_OVEN_RECIPES = (GTERecipeType) GTRecipeTypes.COKE_OVEN_RECIPES;
    GTERecipeType PRIMITIVE_BLAST_FURNACE_RECIPES = (GTERecipeType) GTRecipeTypes.PRIMITIVE_BLAST_FURNACE_RECIPES;
    GTERecipeType BLAST_RECIPES = (GTERecipeType) GTRecipeTypes.BLAST_RECIPES;
    GTERecipeType DISTILLATION_RECIPES = (GTERecipeType) GTRecipeTypes.DISTILLATION_RECIPES;
    GTERecipeType PYROLYSE_RECIPES = (GTERecipeType) GTRecipeTypes.PYROLYSE_RECIPES;
    GTERecipeType CRACKING_RECIPES = (GTERecipeType) GTRecipeTypes.CRACKING_RECIPES;
    GTERecipeType IMPLOSION_RECIPES = (GTERecipeType) GTRecipeTypes.IMPLOSION_RECIPES;
    GTERecipeType VACUUM_RECIPES = (GTERecipeType) GTRecipeTypes.VACUUM_RECIPES;
    GTERecipeType ASSEMBLY_LINE_RECIPES = (GTERecipeType) GTRecipeTypes.ASSEMBLY_LINE_RECIPES;
    GTERecipeType LARGE_CHEMICAL_RECIPES = (GTERecipeType) GTRecipeTypes.LARGE_CHEMICAL_RECIPES;
    GTERecipeType FUSION_RECIPES = (GTERecipeType) GTRecipeTypes.FUSION_RECIPES;
    GTERecipeType DUMMY_RECIPES = (GTERecipeType) GTRecipeTypes.DUMMY_RECIPES;

    GTERecipeType PRIMITIVE_VOID_ORE_RECIPES = GTEConfig.INSTANCE.enablePrimitiveVoidOre ?
            register("primitive_void_ore", "原始虚空采矿", MULTIBLOCK)
                    .setMaxIOSize(0, 0, 1, 0)
                    .setMaxTooltips(1)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
                    .setSound(GTSoundEntries.MINER) :
            null;

    GTERecipeType RADIATION_HATCH_RECIPES = register("radiation_hatch", "放射仓材料", MULTIBLOCK)
            .setMaxIOSize(1, 0, 0, 0)
            .setEUIO(IO.NONE)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.radioactivity", data.getInt("radioactivity")));

    GTERecipeType ARC_GENERATOR_RECIPES = register("arc_generator", "电弧发生器", ELECTRIC)
            .setMaxIOSize(6, 1, 6, 1)
            .setSlotOverlay(true, false, false, GuiTextures.LIGHTNING_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.LIGHTNING_OVERLAY_2)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType DEHYDRATOR_RECIPES = register("dehydrator", "脱水机", ELECTRIC)
            .setMaxIOSize(2, 6, 2, 2)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType UNPACKER_RECIPES = register("unpacker", "解包机", ELECTRIC)
            .setMaxIOSize(2, 2, 0, 0)
            .setEUIO(IO.IN)
            .prepareBuilder(recipeBuilder -> recipeBuilder.EUt(12).duration(10))
            .setSlotOverlay(false, false, true, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOXED_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_UNPACKER, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER);

    GTERecipeType CLUSTER_RECIPES = register("cluster", "多辊式轧机", ELECTRIC)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MOTOR);

    GTERecipeType ROLLING_RECIPES = register("rolling", "辊轧机", ELECTRIC)
            .setMaxIOSize(2, 1, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MOTOR);

    GTERecipeType LAMINATOR_RECIPES = register("laminator", "过胶机", ELECTRIC)
            .setMaxIOSize(3, 1, 1, 0)
            .setEUIO(IO.IN)
            .setSlotOverlay(false, false, GuiTextures.CIRCUIT_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

    GTERecipeType LOOM_RECIPES = register("loom", "织布机", ELECTRIC)
            .setMaxIOSize(2, 1, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_WIREMILL, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MOTOR);

    GTERecipeType LASER_WELDER_RECIPES = register("laser_welder", "激光焊接器", ELECTRIC)
            .setMaxIOSize(3, 1, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_WIREMILL, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType WORLD_DATA_SCANNER_RECIPES = register("world_data_scanner", "世界信息扫描仪", ELECTRIC)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType VACUUM_PUMP_RECIPES = register("vacuum_pump", "真空泵", STEAM)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.TURBINE);

    GTERecipeType THERMAL_GENERATOR_FUELS = register("thermal_generator", "热力发电", GENERATOR)
            .setMaxIOSize(1, 0, 1, 0).setEUIO(IO.OUT)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMBUSTION);

    GTERecipeType SEMI_FLUID_GENERATOR_FUELS = register("semi_fluid_generator", "半流质燃烧", GENERATOR)
            .setMaxIOSize(0, 0, 2, 0).setEUIO(IO.OUT)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMBUSTION);

    GTERecipeType SUPERCRITICAL_STEAM_TURBINE_FUELS = register("supercritical_steam_turbine", "超临界蒸汽发电", GENERATOR)
            .setMaxIOSize(0, 0, 1, 1)
            .setEUIO(IO.OUT)
            .setSlotOverlay(false, true, true, GuiTextures.CENTRIFUGE_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.TURBINE);

    GTERecipeType ROCKET_ENGINE_FUELS = register("rocket_engine", "火箭燃料", GENERATOR)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 0, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.JET_ENGINE);

    GTERecipeType NAQUADAH_REACTOR = register("naquadah_reactor", "硅岩反应", GENERATOR)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 0, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMBUSTION);

    GTERecipeType EVAPORATION_RECIPES = register("evaporation", "蒸发", ELECTRIC)
            .setMaxIOSize(0, 0, 1, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MOTOR);

    GTERecipeType ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES = register("electric_implosion_compressor", "电力聚爆压缩", MULTIBLOCK)
            .setMaxIOSize(2, 1, 0, 0).setEUIO(IO.IN)
            .prepareBuilder(recipeBuilder -> recipeBuilder.duration(20).EUt(GTValues.VA[GTValues.UV]))
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(new ExistingSoundEntry(SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS));

    GTERecipeType DISASSEMBLY_RECIPES = register("disassembly", "拆解", MULTIBLOCK)
            .setMaxIOSize(1, 16, 0, 4)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER);

    GTERecipeType NEUTRON_ACTIVATOR_RECIPES = register("neutron_activator", "中子活化", MULTIBLOCK)
            .setMaxIOSize(6, 3, 1, 1)
            .setSound(GTSoundEntries.COOLING)
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.ev_min", data.getInt("ev_min")))
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.ev_max", data.getInt("ev_max")))
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.evt", data.getInt("evt")));

    GTERecipeType HEAT_EXCHANGER_RECIPES = register("heat_exchanger", "流体热交换", MULTIBLOCK)
            .setMaxIOSize(0, 0, 2, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, LEFT_TO_RIGHT)
            .setMaxTooltips(1)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType ELEMENT_COPYING_RECIPES = register("element_copying", "元素复制", MULTIBLOCK)
            .setMaxIOSize(1, 1, 1, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType INTEGRATED_ORE_PROCESSOR = register("integrated_ore_processor", "集成矿石处理", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 9, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR);

    GTERecipeType FISSION_REACTOR_RECIPES = register("fission_reactor", "裂变反应堆", MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.frheat", FormattingUtil.formatNumbers(data.getInt("FRheat"))));

    GTERecipeType STELLAR_FORGE_RECIPES = register("stellar_forge", "恒星热能熔炼", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 2, 9, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(data -> {
                String tierString = switch (data.getInt(STELLAR_CONTAINMENT_TIER)) {
                    case 3 -> I18n.get("gtocore.tier.ultimate");
                    case 2 -> I18n.get("gtocore.tier.advanced");
                    default -> I18n.get("gtocore.tier.base");
                };
                return LocalizationUtils.format(TierCasingTrait.getTierTranslationKey(STELLAR_CONTAINMENT_TIER), tierString);
            });

    GTERecipeType COMPONENT_ASSEMBLY_RECIPES = register("component_assembly", "部件装配", MULTIBLOCK)
            .setMaxIOSize(9, 1, 9, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(data -> LocalizationUtils.format(TierCasingTrait.getTierTranslationKey(COMPONENT_ASSEMBLY_CASING_TIER), GTValues.VN[data.getInt(COMPONENT_ASSEMBLY_CASING_TIER)]))
            .setSound(GTSoundEntries.ASSEMBLER);

    GTERecipeType GREENHOUSE_RECIPES = register("greenhouse", "温室培育", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMANAIO(IO.IN)
            .setMaxIOSize(3, 1, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE_RECIPES = register("dimensionally_transcendent_plasma_forge", "超维度熔炼", MULTIBLOCK)
            .setMaxIOSize(2, 2, 2, 2)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, LEFT_TO_RIGHT)
            .setSound(GTESoundEntries.DTPF)
            .addDataInfo(data -> LocalizationUtils.format("gtceu.recipe.temperature", FormattingUtil.formatNumbers(data.getInt("ebf_temp"))))
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                ICoilType requiredCoil = ICoilType.getMinRequiredType(temp);
                if (requiredCoil != null && requiredCoil.getMaterial() != null) {
                    return LocalizationUtils.format("gtceu.recipe.coil.tier", (temp > 21600 && temp <= 32000) ? "超级热容" : I18n.get(requiredCoil.getMaterial().getUnlocalizedName()));
                }
                return "";
            })
            .setUiBuilder((recipe, widgetGroup) -> {
                List<List<ItemStack>> items = new ArrayList<>();
                int temp = recipe.data.getInt("ebf_temp");
                items.add(GTCEuAPI.HEATING_COILS.entrySet().stream().filter(coil -> {
                    int ctemp = coil.getKey().getCoilTemperature();
                    if (ctemp == 273) {
                        return temp <= 32000;
                    } else {
                        return ctemp >= temp;
                    }
                }).map(coil -> new ItemStack(coil.getValue().get())).toList());
                widgetGroup.addWidget(new SlotWidget(new CycleItemStackHandler(items), 0, widgetGroup.getSize().width - 25, widgetGroup.getSize().height - 32, false, false));
            });

    GTERecipeType PLASMA_CONDENSER_RECIPES = register("plasma_condenser", "等离子冷凝", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 2, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType RARE_EARTH_CENTRIFUGAL_RECIPES = register("rare_earth_centrifugal", "稀土离心", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 17, 1, 1)
            .setProgressBar(GuiTextures.CENTRIFUGE_OVERLAY, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    GTERecipeType TRANSCENDING_CRAFTING_RECIPES = register("transcending_crafting", "超临界合成", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 1, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType MATTER_FABRICATOR_RECIPES = register("matter_fabricator", "物质制造", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 0, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType LARGE_VOID_MINER_RECIPES = register("large_void_miner", "Precise Void Mining", "精准虚空采矿", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 4, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MINER);

    GTERecipeType RANDOM_ORE_RECIPES = register("random_ore", "Random Void Mining", "随机虚空采矿", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 200, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setXEIVisible(false)
            .setSound(GTSoundEntries.MINER);

    GTERecipeType ANNIHILATE_GENERATOR_RECIPES = register("annihilate_generator", "湮灭发电", MULTIBLOCK)
            .setEUIO(IO.OUT)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType HYPER_REACTOR_RECIPES = register("hyper_reactor", "超能反应", MULTIBLOCK)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 0, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType ADVANCED_HYPER_REACTOR_RECIPES = register("advanced_hyper_reactor", "进阶超能反应", MULTIBLOCK)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 0, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType LARGE_NAQUADAH_REACTOR_RECIPES = register("large_naquadah_reactor", "进阶硅岩反应", MULTIBLOCK)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 0, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMBUSTION);

    GTERecipeType COSMOS_SIMULATION_RECIPES = register("cosmos_simulation", "宇宙模拟", MULTIBLOCK)
            .setMaxIOSize(1, 120, 1, 24)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(data -> I18n.get("tooltip.avaritia.tier", data.getInt("tier")));

    GTERecipeType SPACE_PROBE_SURFACE_RECEPTION_RECIPES = register("space_probe_surface_reception", "宇宙射线搜集", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setMaxIOSize(2, 0, 0, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType DECAY_HASTENER_RECIPES = register("decay_hastener", "衰变扭曲", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType RECYCLER_RECIPES = register("recycler", "材料回收", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_RECYCLER, LEFT_TO_RIGHT)
            .addCustomRecipeLogic(new RecyclerLogic())
            .setSound(GTSoundEntries.MACERATOR);

    GTERecipeType MASS_FABRICATOR_RECIPES = register("mass_fabricator", "质量发生器", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_REPLICATOR, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType CIRCUIT_ASSEMBLY_LINE_RECIPES = register("circuit_assembly_line", "电路装配线", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(16, 1, 4, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER)
            .onRecipeBuild(GenerateDisassembly::generateDisassembly);

    GTERecipeType SUPRACHRONAL_ASSEMBLY_LINE_RECIPES = register("suprachronal_assembly_line", "超时空装配线", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setMaxIOSize(16, 1, 4, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setHasResearchSlot(true)
            .onRecipeBuild((recipeBuilder, provider) -> {
                ResearchManager.createDefaultResearchRecipe(recipeBuilder, provider);
                GenerateDisassembly.generateDisassembly(recipeBuilder, provider);
            });

    GTERecipeType PRECISION_ASSEMBLER_RECIPES = register("precision_assembler", "精密组装", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setMaxIOSize(4, 1, 4, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER)
            .onRecipeBuild((b, p) -> {
                GenerateDisassembly.generateDisassembly(b, p);
                int tier = GTUtil.getFloorTierByVoltage(b.EUt());
                b.addData(MACHINE_CASING_TIER, tier);
            });

    GTERecipeType ASSEMBLER_MODULE_RECIPES = register("assembler_module", "Space Assembly", "太空组装", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(16, 1, 4, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER)
            .onRecipeBuild(GenerateDisassembly::generateDisassembly)
            .addDataInfo(data -> LocalizationUtils.format(TierCasingTrait.getTierTranslationKey(POWER_MODULE_TIER), FormattingUtil.formatNumbers(data.getInt(POWER_MODULE_TIER))));

    GTERecipeType MINER_MODULE_RECIPES = register("miner_module", "Space Miner", "太空采矿", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 6, 1, 0)
            .setProgressBar(GTEGuiTextures.PROGRESS_BAR_MINING_MODULE, UP_TO_DOWN)
            .setSound(GTSoundEntries.MINER);

    GTERecipeType DRILLING_MODULE_RECIPES = register("drilling_module", "Space Drilling", "太空钻井", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 0, 1, 1)
            .setProgressBar(GTEGuiTextures.PROGRESS_BAR_DRILLING_MODULE, UP_TO_DOWN)
            .setSound(GTSoundEntries.MINER);

    GTERecipeType FISHING_GROUND_RECIPES = register("fishing_ground", "渔场", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 24, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MINER);

    GTERecipeType BLOCK_CONVERSIONRECIPES = register("block_conversion", "方块转换", MULTIBLOCK)
            .setEUIO(IO.IN)
            .noSearch(true)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType INCUBATOR_RECIPES = register("incubator", "培养缸", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(6, 1, 2, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING)
            .addDataInfo(data -> {
                String filterCasing = switch (data.getInt("filter_casing")) {
                    case 3 -> "T3：" + I18n.get("block.gtocore.law_filter_casing");
                    case 2 -> "T2：" + I18n.get("block.gtceu.sterilizing_filter_casing");
                    default -> "T1：" + I18n.get("block.gtceu.filter_casing");
                };
                return LocalizationUtils.format("gtceu.recipe.cleanroom", filterCasing);
            })
            .addDataInfo(data -> data.contains("radioactivity") ? LocalizationUtils.format("gtocore.recipe.radioactivity", data.getInt("radioactivity")) : "")
            .onRecipeBuild((b, p) -> b.addData(GLASS_TIER, GTUtil.getFloorTierByVoltage(b.EUt())));

    GTERecipeType PCB_FACTORY_RECIPES = register("pcb_factory", "PCB工厂", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    GTERecipeType LAVA_FURNACE_RECIPES = register("lava_furnace", "熔岩炉", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 0, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    GTERecipeType LARGE_GAS_COLLECTOR_RECIPES = register("large_gas_collector", "Void Gas Collector", "虚空集气", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 0, 0, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType AGGREGATION_DEVICE_RECIPES = register("aggregation_device", "聚合装置", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(9, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType SUPER_PARTICLE_COLLIDER_RECIPES = register("super_particle_collider", "粒子对撞", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 2, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTESoundEntries.FUSIONLOOP);

    GTERecipeType DIMENSIONAL_FOCUS_ENGRAVING_ARRAY_RECIPES = register("dimensional_focus_engraving_array", "维度聚焦激光蚀刻阵列", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setMaxIOSize(2, 1, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .setHasResearchSlot(true)
            .onRecipeBuild(ResearchManager::createDefaultResearchRecipe);

    GTERecipeType PRECISION_LASER_ENGRAVER_RECIPES = register("precision_laser_engraver", "精密激光蚀刻", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setMaxIOSize(9, 1, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType DIMENSIONALLY_TRANSCENDENT_MIXER_RECIPES = register("dimensionally_transcendent_mixer", "超维度搅拌", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(9, 1, 6, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MIXER);

    GTERecipeType NEUTRON_COMPRESSOR_RECIPES = register("neutron_compressor", "奇点压缩", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMPRESSOR);

    GTERecipeType QUANTUM_FORCE_TRANSFORMER_RECIPES = register("quantum_force_transformer", "量子操纵者", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(18, 1, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType DRAGON_EGG_COPIER_RECIPES = register("dragon_egg_copier", "龙蛋复制", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 2, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType DOOR_OF_CREATE_RECIPES = register("door_of_create", "创造之门", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setMaxIOSize(1, 0, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setXEIVisible(false);

    GTERecipeType BEDROCK_DRILLING_RIG_RECIPES = register("bedrock_drilling_rig", "基岩素提取", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR);

    GTERecipeType CREATE_AGGREGATION_RECIPES = register("create_aggregation", "创造聚合", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .setXEIVisible(false);

    GTERecipeType GRAVITATION_SHOCKBURST_RECIPES = register("gravitation_shockburst", "时空引力震爆", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR)
            .onRecipeBuild(ResearchManager::createDefaultResearchRecipe);

    GTERecipeType ULTIMATE_MATERIAL_FORGE_RECIPES = register("ultimate_material_forge", "终极物质锻造", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 2, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR);

    GTERecipeType DYSON_SPHERE_RECIPES = register("dyson_sphere", "戴森球", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType PETROCHEMICAL_PLANT_RECIPES = register("petrochemical_plant", "集成石油化工处理", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 2, 12)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType WEATHER_CONTROL_RECIPES = register("weather_control", "天气控制", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .setXEIVisible(false);

    GTERecipeType NANITES_INTEGRATED_PROCESSING_CENTER_RECIPES = register("nanites_integrated_processing_center", "纳米集成加工中心", MULTIBLOCK)
            .setMaxIOSize(9, 9, 9, 9)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI)
            .addDataInfo(data -> switch (data.getInt("module")) {
                case 0 -> I18n.get("gtocore.machine.need", I18n.get("block.gtocore.nanites_integrated_processing_center"));
                case 1 -> I18n.get("gtocore.machine.need", I18n.get("block.gtocore.ore_extraction_module"));
                case 2 -> I18n.get("gtocore.machine.need", I18n.get("block.gtocore.bioengineering_module"));
                case 3 -> I18n.get("gtocore.machine.need", I18n.get("block.gtocore.polymer_twisting_module"));
                default -> "";
            })
            .setMaxTooltips(5)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType NANO_FORGE_RECIPES = register("nano_forge", "纳米蜂群工厂", MULTIBLOCK)
            .setMaxIOSize(6, 1, 3, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.nano_forge_tier", FormattingUtil.formatNumbers(data.getInt("nano_forge_tier"))))
            .setSound(GTSoundEntries.ARC);

    GTERecipeType FUEL_REFINING_RECIPES = register("fuel_refining", "燃料精炼", MULTIBLOCK)
            .setMaxIOSize(3, 0, 6, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType ATOMIC_ENERGY_EXCITATION_RECIPES = register("atomic_energy_excitation", "原子能激发", MULTIBLOCK)
            .setMaxIOSize(3, 0, 6, 2)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType ISA_MILL_RECIPES = register("isa_mill", "湿法碾磨", MULTIBLOCK)
            .setMaxIOSize(2, 1, 1, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR)
            .addDataInfo(data -> LocalizationUtils.format("gtocore.recipe.grindball", I18n.get(data.getInt("grindball") == 2 ? "material.gtceu.aluminium" : "material.gtceu.soapstone")));

    GTERecipeType FLOTATING_BENEFICIATION_RECIPES = register("flotating_beneficiation", "浮游选矿", MULTIBLOCK)
            .setMaxIOSize(2, 0, 1, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    GTERecipeType VACUUM_DRYING_RECIPES = register("vacuum_drying", "真空干燥", MULTIBLOCK)
            .setMaxIOSize(0, 6, 1, 2)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI);

    GTERecipeType DISSOLUTION_TREATMENT_RECIPES = register("dissolution_treatment", "溶解", MULTIBLOCK)
            .setMaxIOSize(2, 2, 2, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType DIGESTION_TREATMENT_RECIPES = register("digestion_treatment", "煮解", MULTIBLOCK)
            .setMaxIOSize(1, 1, 1, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI);

    GTERecipeType WOOD_DISTILLATION_RECIPES = register("wood_distillation", "集成木质生物质热解", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 1, 1, 15)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

    GTERecipeType DESULFURIZER_RECIPES = register("desulfurizer", "脱硫", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MIXER);

    GTERecipeType LIQUEFACTION_FURNACE_RECIPES = register("liquefaction_furnace", "高温液化", MULTIBLOCK)
            .setMaxIOSize(1, 0, 0, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL);

    GTERecipeType REACTION_FURNACE_RECIPES = register("reaction_furnace", "高温反应", MULTIBLOCK)
            .setMaxIOSize(3, 3, 3, 3)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI);

    GTERecipeType STEAM_CRACKING_RECIPES = register("steam_cracker", "蒸汽裂化", MULTIBLOCK)
            .setMaxIOSize(1, 0, 2, 1)
            .setEUIO(IO.IN)
            .setSlotOverlay(false, true, GuiTextures.CRACKING_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.CRACKING_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FIRE);

    GTERecipeType CRUSHER_RECIPES = register("crusher", "Ore Crusher", "矿石破碎", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setSlotOverlay(false, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setMaxIOSize(1, 3, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MACERATOR);

    GTERecipeType MOLECULAR_TRANSFORMER_RECIPES = register("molecular_transformer", "物质重组", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType THREE_DIMENSIONAL_PRINTER_RECIPES = register("three_dimensional_printer", "3D Printer", "3D打印", MULTIBLOCK)
            .setMaxIOSize(1, 1, 1, 0)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType SINTERING_FURNACE_RECIPES = register("sintering_furnace", "烧结炉", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI);

    GTERecipeType ISOSTATIC_PRESSING_RECIPES = register("isostatic_pressing", "等静压成型", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 1, 1, 0)
            .setProgressBar(GuiTextures.COMPRESSOR_OVERLAY, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMPRESSOR);

    GTERecipeType CHEMICAL_VAPOR_DEPOSITION_RECIPES = register("chemical_vapor_deposition", "化学气相沉积", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 1, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    GTERecipeType TREE_GROWTH_SIMULATOR_RECIPES = register("tree_growth_simulator", "原木拟生场", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 2, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType ELECTRIC_COOKING_RECIPES = register("electric_cooking", "电力烹饪", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(7, 2, 2, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    GTERecipeType DRAWING_RECIPES = register("drawing", "拉丝", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxTooltips(5)
            .setMaxIOSize(2, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_WIREMILL, LEFT_TO_RIGHT)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setSound(GTSoundEntries.COMPRESSOR)
            .setUiBuilder((recipe, widgetGroup) -> {
                ItemStack itemStack = new ItemStack(SPOOL.entrySet().stream()
                        .filter(entry -> entry.getValue() == recipe.data.getInt("spool"))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new)
                        .getKey());
                widgetGroup.addWidget(new SlotWidget(new CycleItemStackHandler(List.of(List.of(itemStack))), 0,
                        widgetGroup.getSize().width - 50, widgetGroup.getSize().height - 40, false, false));
            });

    GTERecipeType ROCKET_ASSEMBLER_RECIPES = register("rocket_assembler", "火箭装配", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(9, 1, 3, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ASSEMBLER);

    GTERecipeType POLYMERIZATION_REACTOR_RECIPES = register("polymerization_reactor", "聚合反应", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 1, 3, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    GTERecipeType WATER_PURIFICATION_PLANT_RECIPES = register("water_purification_plant", "净化水厂", MULTIBLOCK)
            .noSearch(true)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC)
            .addDataInfo(data -> LocalizationUtils.format("tooltip.avaritia.tier", data.getInt("tier")));

    GTERecipeType PHYSICAL_VAPOR_DEPOSITION_RECIPES = register("physical_vapor_deposition", "物理气相沉积", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 1, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType CRYSTALLIZATION_RECIPES = register("crystallization", "结晶", MULTIBLOCK)
            .setMaxIOSize(3, 1, 2, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE)
            .addDataInfo(TEMPERATURE)
            .addDataInfo(COIL)
            .setUiBuilder(COIL_UI);

    GTERecipeType BIOCHEMICAL_REACTION_RECIPES = register("biochemical_reaction", "生化反应", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 2, 5, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .addDataInfo(data -> data.contains("radioactivity") ? LocalizationUtils.format("gtocore.recipe.radioactivity", data.getInt("radioactivity")) : "")
            .setSound(GTSoundEntries.COOLING);

    GTERecipeType BIOCHEMICAL_EXTRACTION_RECIPES = register("biochemical_extraction", "生物提取", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 6, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType GAS_COMPRESSOR_RECIPES = register("gas_compressor", "气体压缩", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 1, 1)
            .setProgressBar(GuiTextures.COMPRESSOR_OVERLAY, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMPRESSOR);

    GTERecipeType RARITY_FORGE_RECIPES = register("rarity_forge", "珍宝锻炉", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(3, 1, 0, 0)
            .setProgressBar(GuiTextures.COMPRESSOR_OVERLAY, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    // TODO 添加用途
    GTERecipeType PLASMA_CENTRIFUGE_RECIPES = register("plasma_centrifuge", "等离子体离心", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 0, 1, 9)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType PLASMA_EXTRACTION_RECIPES = register("plasma_extraction", "等离子体萃取", MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    //////////////////////////////////////
    // ********** Magic **********//
    //////////////////////////////////////
    GTERecipeType ALCHEMY_CAULDRON_RECIPES = register("alchemy_cauldron", "炼金锅", MAGIC)
            .setMANAIO(IO.IN)
            .setMaxIOSize(6, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING)
            .addDataInfo(data -> {
                int temperature = data.getInt("temperature");
                if (temperature > 0) {
                    return I18n.get("gtceu.multiblock.hpca.temperature", temperature);
                }
                return "";
            });

    GTERecipeType MANA_HEATER_RECIPES = register("mana_heater", "魔力加热器", MAGIC)
            .setMaxIOSize(0, 0, 1, 0)
            .setSound(GTSoundEntries.FURNACE);

    GTERecipeType MANA_INFUSER_RECIPES = register("mana_infuser", "魔力灌注", MAGIC)
            .setMANAIO(IO.IN)
            .setMaxIOSize(1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

    GTERecipeType MANA_CONDENSER_RECIPES = register("mana_condenser", "魔力凝聚", MAGIC)
            .setMANAIO(IO.IN)
            .setMaxIOSize(3, 1, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FIRE);

    GTERecipeType ELF_EXCHANGE_RECIPES = register("elf_exchange", "ELF Exchange", "精灵交易", MAGIC)
            .setMANAIO(IO.IN)
            .setMaxIOSize(2, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.REPLICATOR);

    GTERecipeType INDUSTRIAL_ALTAR_RECIPES = register("industrial_altar", "工业祭坛", MAGIC)
            .setMANAIO(IO.IN)
            .setMaxIOSize(12, 1, 3, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType MANA_SIMULATOR_RECIPES = register("mana_simulator", "魔力模拟室", GENERATOR)
            .setEUIO(IO.IN)
            .setMANAIO(IO.OUT)
            .setMaxIOSize(2, 2, 2, 2)
            .setMaxTooltips(5)
            .setProgressBar(GuiTextures.PROGRESS_BAR_BATH, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    GTERecipeType MANA_SIMULATOR_FUEL = register("mana_simulator_fuel", "魔力模拟室：燃料", GENERATOR)
            .setEUIO(IO.IN)
            .setMANAIO(IO.OUT)
            .setMaxIOSize(1, 0, 1, 0)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setMaxTooltips(5)
            .setSound(GTSoundEntries.FIRE);
    //////////////////////////////////////
    // ********** Joint **********//
    //////////////////////////////////////
    GTERecipeType CHEMICAL = JointRecipeType.register("chemical", CHEMICAL_RECIPES, LARGE_CHEMICAL_RECIPES).setMaxIOSize(3, 3, 5, 4).setEUIO(IO.IN).setSound(GTSoundEntries.CHEMICAL);
    GTERecipeType CHEMICAL_ENERGY_DEVOURER_FUELS = JointRecipeType.register("chemical_energy_devourer", COMBUSTION_GENERATOR_FUELS, GAS_TURBINE_FUELS, ROCKET_ENGINE_FUELS).setSound(GTSoundEntries.COMBUSTION);
}
