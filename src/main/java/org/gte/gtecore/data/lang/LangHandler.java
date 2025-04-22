package org.gte.gtecore.data.lang;

import org.gte.gtecore.api.machine.trait.TierCasingTrait;
import org.gte.gtecore.api.registries.GTEMachineBuilder;
import org.gte.gtecore.api.registries.MultiblockBuilder;
import org.gte.gtecore.client.Tooltips;
import org.gte.gtecore.common.data.GTEBedrockFluids;
import org.gte.gtecore.data.lang.provider.SimplifiedChineseLanguageProvider;
import org.gte.gtecore.data.lang.provider.TraditionalChineseLanguageProvider;
import org.gte.gtecore.utils.ChineseConverter;
import org.gte.gtecore.utils.register.BlockRegisterUtils;
import org.gte.gtecore.utils.register.ItemRegisterUtils;
import org.gte.gtecore.utils.register.MaterialsRegisterUtils;
import org.gte.gtecore.utils.register.RecipeTypeRegisterUtils;

import com.gregtechceu.gtceu.api.GTValues;

import net.minecraftforge.common.data.LanguageProvider;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Arrays;
import java.util.Map;

import static net.minecraft.ChatFormatting.GOLD;
import static net.minecraft.ChatFormatting.RESET;
import static org.gte.gtecore.api.GTEValues.*;

public final class LangHandler {

    private static final Map<String, ENCN> LANGS = new Object2ObjectOpenHashMap<>();

    private static void addENCN(String key, ENCN encn) {
        LANGS.put(key, encn);
    }

    static void addENCN(String key, String en, String cn) {
        addENCN(key, new ENCN(en, cn));
    }

    private static void addCN(String key, String cn) {
        addENCN(key, null, cn);
    }

    private static void init() {
        MaterialsRegisterUtils.LANG.forEach((k, v) -> addENCN("material.gtecore." + k, v));
        RecipeTypeRegisterUtils.LANG.forEach((k, v) -> addENCN("gtceu." + k, v));
        GTEBedrockFluids.LANG.forEach((k, v) -> addENCN("gtceu.jei.bedrock_fluid." + k, v));
        ItemRegisterUtils.LANG.forEach((k, v) -> addCN("item.gtecore." + k, v));
        BlockRegisterUtils.LANG.forEach((k, v) -> addCN("block.gtecore." + k, v));
        GTEMachineBuilder.TOOLTIPS_MAP.forEach(LangHandler::addENCN);
        MultiblockBuilder.TOOLTIPS_MAP.forEach(LangHandler::addENCN);
        Tooltips.LANG.forEach(LangHandler::addENCN);

        addCN("entity.gtecore.task_entity", "任务执行实体");
        addCN("itemGroup.gtecore.block", "GTE | 方块");
        addCN("itemGroup.gtecore.item", "GTE | 物品");
        addCN("itemGroup.gtecore.machine", "GTE | 机器");
        addCN("itemGroup.gtecore.material_block", "GTE | 材料方块");
        addCN("itemGroup.gtecore.material_fluid", "GTE | 材料流体");
        addCN("itemGroup.gtecore.material_item", "GTE | 材料物品");
        addCN("itemGroup.gtecore.material_pipe", "GTE | 材料管道");

        for (int tier = GTValues.UHV; tier < 16; tier++) {
            int a = (1 << (2 * (tier - 4)));
            addENCN("gtceu.machine.parallel_hatch_mk" + tier + ".tooltip", "Allows to run up to " + a + " recipes in parallel.", "允许同时处理至多" + a + "个配方。");
        }

        addENCN("gtceu.machine.available_recipe_map_5.tooltip", "Available Recipe Types: %s, %s, %s, %s, %s", "可用配方类型：%s，%s，%s，%s，%s");
        addENCN("gtceu.machine.available_recipe_map_6.tooltip", "Available Recipe Types: %s, %s, %s, %s, %s, %s", "可用配方类型：%s，%s，%s，%s，%s，%s");

        addENCN("key.gtecore.flyingspeed", "Flight Speed Adjustment", "飞行速度调节");
        addENCN("key.gtecore.nightvision", "Night Vision Toggle", "夜视开关");
        addENCN("key.gtecore.vajra", "Vajra Key", "金刚杵按键");
        addENCN("key.gtecore.drift", "Flight Inertia", "飞行惯性");
        addENCN("key.keybinding.gtecore", "GTE Key Bindings", "GTE按键绑定");

        addENCN("structure_writer.export_order", "Export Order: C:%s  S:%s  A:%s", "导出顺序： C:%s  S:%s  A:%s");
        addENCN("structure_writer.structural_scale", "Structural Scale: X:%s  Y:%s  Z:%s", "结构规模： X:%s  Y:%s  Z:%s");

        addENCN("gtecore.pattern.blocking_mode", "Block insertion when the container has any content (except for programming circuits)", "容器有任何内容时阻止插入（编程电路除外）");
        addENCN("gtecore.pattern.blocking_reverse", "Reverse", "反转");
        addENCN("gtecore.pattern.multiply", "Pattern Recipe x %s", "样板配方 x %s");
        addENCN("gtecore.pattern.tooltip.multiply", "Multiply Pattern materials amount by %s", "将样板材料数量 x %s");
        addENCN("gtecore.pattern.divide", "Pattern Recipe ÷ %s", "样板配方 ÷ %s");
        addENCN("gtecore.pattern.tooltip.divide", "Divide Pattern materials amount by %s", "将样板材料数量 ÷ %s");

        addENCN("gtecore.dev", "The current version is a development test version and cannot guarantee the stability and completeness of the content. If you encounter any issues or have any suggestions, please go to %s to provide feedback.", "当前版本是开发测试版本，不能保证内容的稳定性和完整性。如果您遇到任何问题或有任何建议，请前往%s提供反馈。");
        addENCN("gtecore.fly_speed_reset", "fly Speed Reset", "飞行速度已重置");
        addENCN("gtecore.fly_speed", "fly Speed x%s", "飞行速度 x%s");
        addENCN("gtecore.reach_limit", "Reach Limit", "达到极限");
        addENCN("gtecore.me_any", "ME hatch allows connection from any side.", "ME仓允许任意面连接");
        addENCN("gtecore.me_front", "ME hatch only allows connection from the front side.", "ME仓只允许正面连接");
        addENCN("gtecore.unlocked", "Unlocked", "解锁的");
        addENCN("gtecore.ununlocked", "Ununlocked", "未解锁");
        addENCN("gtecore.build", "Build", "构建");

        addENCN("config.gtecore.option.enableAnimalsAreAfraidToEatTheirMeat", "Enable Animals Are Afraid To Eat Their Meat", "启用动物害怕他们的肉被吃");
        addENCN("config.gtecore.option.enableAnimalsAreAfraidToEatTheirMeatRange", "Enable Animals Are Afraid To Eat Their Meat's Range", "启用动物害怕他们的肉被吃的范围");
        addENCN("gtecore.patternModifierPro.0", "After setup,shift + right-click template provider to apply", "设置完成后，潜行右击样板供应器以应用");
        addENCN("gtecore.patternModifierPro.1", "Set Item and Fluid Multiplier", "模板乘数：所有物品和流体乘以指定倍数");
        addENCN("gtecore.patternModifierPro.2", "Set Item and Fluid Divider", "模板乘数：所有物品和流体除以指定倍数");
        addENCN("gtecore.patternModifierPro.3", "Set Maximum Item Count", "最大物品数：所有物品不会超过此数量");
        addENCN("gtecore.patternModifierPro.4", "Set Maximum Fluid Amount / Bucket", "最大流体数：所有流体不会超过此桶数");
        addENCN("gtecore.patternModifierPro.5", "Set Application Cycles , Up to 16", "应用次数为：循环上述操作次数，最大为16");

        addENCN("config.gtecore.option.disableDrift", "Whether to turn off flight inertia", "是否关闭飞行惯性");
        addENCN("config.gtecore.option.travelStaffCD", "Travel Scepter Minimal CD", "旅行权杖最小CD");
        addENCN("config.gtecore.option.selfRestraint", "Self Restraint Mode", "自我约束模式");
        addENCN("config.gtecore.option.eioFluidRate", "EIO Fluid Pipe Rate Multiplier", "EIO流体管道速率倍数");
        addENCN("config.gtecore.option.enablePrimitiveVoidOre", "Enable Primitive Void Ore Machine", "启用原始虚空矿机");
        addENCN("config.gtecore.option.oreMultiplier", "Ore Yield Multiplier", "矿石产量乘数");
        addENCN("config.gtecore.option.fastMultiBlockPage", "Fast MultiBlock Page", "优化多方块页面");
        addENCN("config.gtecore.option.synchronousInterval", "Synchronous Interval", "双端同步间隔");
        addENCN("config.gtecore.option.recipeMaxCheckInterval", "Recipe Max Check Interval", "配方最大检查间隔");
        addENCN("config.gtecore.option.asyncRecipeSearch", "Async Recipe Search", "异步配方搜索");
        addENCN("config.gtecore.option.asyncRecipeOutput", "Async Recipe Output", "异步配方输出");
        addENCN("config.gtecore.option.breakBlocksBlackList", "Black List Of Chain Blocks", "连锁挖掘黑名单");
        addENCN("config.screen.gtecore", "GTE Core Config", "GTE Core 配置");
        addENCN("config.gtecore.option.recipeCheck", "[Debug]Recipe Abnormal Check", "[调试]配方异常检查");
        addENCN("config.gtecore.option.dev", "Dev mode", "开发模式");
        addENCN("config.gtecore.option.gameDifficulty", "Game difficulty", "游戏难度");
        addENCN("config.gtecore.option.emiGlobalFavorites", "EMI Global Favorites", "全局 EMI 书签");

        addENCN("gtceu.jei.ore_vein.bauxite_vein", "Bauxite Vein", "铝土矿脉");
        addENCN("gtceu.jei.ore_vein.chromite_vein", "Chromite Vein", "铬铁矿脉");
        addENCN("gtceu.jei.ore_vein.pitchblende_vein", "Pitchblende Vein", "沥青铀矿脉");
        addENCN("gtceu.jei.ore_vein.magnetite_vein", "Magnetite Vein", "磁铁矿脉");
        addENCN("gtceu.jei.ore_vein.titanium_vein", "Titanium Vein", "钛矿脉");
        addENCN("gtceu.jei.ore_vein.calorite_vein", "Calorite Vein", "耐热矿脉");
        addENCN("gtceu.jei.ore_vein.celestine_vein", "Celestine Vein", "天青石矿脉");
        addENCN("gtceu.jei.ore_vein.desh_vein", "Desh Vein", "戴斯矿脉");
        addENCN("gtceu.jei.ore_vein.ostrum_vein", "Ostrum Vein", "紫金矿脉");
        addENCN("gtceu.jei.ore_vein.zircon_vein", "Zircon Vein", "锆石矿脉");

        addENCN(TierCasingTrait.getTierTranslationKey(GRAVITON_FLOW_TIER), "Graviton Flow Tier: %s", "引力流等级：%s");
        addENCN(TierCasingTrait.getTierTranslationKey(GLASS_TIER), "Glass Tier: %s", "玻璃等级：%s");
        addENCN(TierCasingTrait.getTierTranslationKey(MACHINE_CASING_TIER), "Machine Casing Tier: %s", "机器外壳等级：%s");
        addENCN(TierCasingTrait.getTierTranslationKey(COMPONENT_ASSEMBLY_CASING_TIER), "Casing Tier: %s", "外壳等级：%s");
        addENCN(TierCasingTrait.getTierTranslationKey(POWER_MODULE_TIER), "Power Module Tier: %s", "动力模块等级：%s");
        addENCN(TierCasingTrait.getTierTranslationKey(STELLAR_CONTAINMENT_TIER), "Stellar Container Tier: %s", "恒星热力容器等级：%s");
        addENCN(TierCasingTrait.getTierTranslationKey(INTEGRAL_FRAMEWORK_TIER), "Integral Framework Tier: %s", "整体框架等级：%s");
        addENCN("gtecore.recipe.ev_max", "Maximum Neutron Energy: %s MeV", "最大中子动能：%s MeV");
        addENCN("gtecore.recipe.ev_min", "Minimum Neutron Energy: %s MeV", "最小中子动能：%s MeV");
        addENCN("gtecore.recipe.evt", "Energy Consumption per Tick: %s KeV", "每刻中子动能消耗：%s KeV");
        addENCN("gtecore.recipe.frheat", "Heating per Second: %s K", "每秒升温：%s K");
        addENCN("gtecore.recipe.grindball", "macerator Ball Material: %s", "研磨球材质：%s");
        addENCN("gtecore.recipe.spool", "Spool Type: %s", "线轴类型：%s");
        addENCN("gtecore.recipe.law_cleanroom.display_name", "Absolute Clean", "绝对超净间");
        addENCN("gtecore.recipe.nano_forge_tier", "Nano Forge Tier: %s", "纳米锻炉等级：%s");
        addENCN("gtecore.recipe.radioactivity", "Radiation Dose: %s Sv", "辐射剂量：%s Sv");
        addENCN("gtecore.recipe.vacuum.tier", "Vacuum Tier: %s", "真空等级：%s");
        addENCN("gtecore.recipe.restricted_machine", "Only runnable on: %s", "只能运行在：%s");
        addENCN("gtecore.recipe.heat.temperature", "External heat source is required: %s K", "需要外部热源：%s K");
        addENCN("gtecore.recipe.runlimit.count", "Run Limit: %s times", "运行次数限制：%s");
        addENCN("gtecore.recipe.mana_consumption", "Mana Consumption", "魔力消耗");
        addENCN("gtecore.recipe.mana_production", "Mana Production", "魔力产出");
        addENCN("gtecore.condition.gravity", "Requires Strong Gravity Environment", "需要强重力环境");
        addENCN("gtecore.condition.zero_gravity", "Requires Zero Gravity Environment", "需要无重力环境");

        addENCN("gtecore.tier.advanced", "Advanced", "高级");
        addENCN("gtecore.tier.base", "Basic", "基础");
        addENCN("gtecore.tier.ultimate", "Ultimate", "终极");

        addENCN("config.jade.plugin_gtecore.accelerate_provider", "[GTECore] Accelerated Bar", "[GTECore] 加速条");
        addENCN("config.jade.plugin_gtecore.wireless_data_hatch_provider", "[GTECore] Wireless Data", "[GTECore] 无线数据");
        addENCN("config.jade.plugin_gtecore.mana_container_provider", "[GTECore] Mana Container", "[GTECore] 魔力容器");
        addENCN("config.jade.plugin_gtecore.vacuum_tier_provider", "[GTECore] Vacuum Tier", "[GTECore] 真空等级");
        addENCN("config.jade.plugin_gtecore.temperature_provider", "[GTECore] Machine Temperature", "[GTECore] 机器温度");
        addENCN("config.jade.plugin_gtecore.tick_time_provider", "[GTECore] Tick Time", "[GTECore] Tick时间");
        addENCN("config.jade.plugin_gtecore.wireless_interactor_provider", "[GTECore] Wireless Interactive Machine Info", "[GTECore] 无线交互机器信息");
        addENCN("config.jade.plugin_gtecore.upgrade_module_provider", "[GTECore] Upgrade Module Info", "[GTECore] 升级模块信息");

        addENCN("fluid.gtecore.gelid_cryotheum", "Gelid Cryotheum", "极寒之凛冰");

        addENCN("biome.gtecore.ancient_world_biome", "Ancient World", "远古世界");
        addENCN("biome.gtecore.barnarda_c_biome", "Barnarda C", "巴纳德 C");
        addENCN("biome.gtecore.ceres_biome", "Ceres", "谷神星");
        addENCN("biome.gtecore.enceladus_biome", "Enceladus", "土卫二");
        addENCN("biome.gtecore.ganymede_biome", "Ganymede", "木卫三");
        addENCN("biome.gtecore.io_biome", "Io", "木卫二");
        addENCN("biome.gtecore.pluto_biome", "Pluto", "冥王星");
        addENCN("biome.gtecore.titan_biome", "Titan", "土卫六");
        addENCN("biome.gtecore.create", "Create", "创造");
        addENCN("biome.gtecore.void", "Void", "虚空");
        addENCN("biome.gtecore.flat", "Superflat", "超平坦");
        addENCN("planet.gtecore.barnarda_c", "Barnarda C", "巴纳德 C");
        addENCN("planet.gtecore.barnarda_c_orbit", "Barnarda C Orbit", "巴纳德 C轨道");
        addENCN("planet.gtecore.ceres", "Ceres", "谷神星");
        addENCN("planet.gtecore.ceres_orbit", "Ceres Orbit", "谷神星轨道");
        addENCN("planet.gtecore.enceladus", "Enceladus", "土卫二");
        addENCN("planet.gtecore.enceladus_orbit", "Enceladus Orbit", "土卫二轨道");
        addENCN("planet.gtecore.ganymede", "Ganymede", "木卫三");
        addENCN("planet.gtecore.ganymede_orbit", "Ganymede Orbit", "木卫三轨道");
        addENCN("planet.gtecore.io", "Io", "木卫一");
        addENCN("planet.gtecore.io_orbit", "Io Orbit", "木卫一轨道");
        addENCN("planet.gtecore.pluto", "Pluto", "冥王星");
        addENCN("planet.gtecore.pluto_orbit", "Pluto Orbit", "冥王星轨道");
        addENCN("planet.gtecore.titan", "Titan", "土卫六");
        addENCN("planet.gtecore.titan_orbit", "Titan Orbit", "土卫六轨道");
        addENCN("gui.ad_astra.text.barnarda", "Barnarda", "巴纳德");

        addENCN("gtecore.player_exp_status.header", "========== Player Experience Status ==========", "=========== 玩家经验状态 ===========");
        addENCN("gtecore.player_exp_status.footer", "\n===========================================", "\n================================");
        addENCN("gtecore.player_exp_status.player", "\nPlayer: ", "\n玩家: ");
        addENCN("gtecore.player_exp_status.level", "\n  Level: ", "\n  等级: ");
        addENCN("gtecore.player_exp_status.level_max", "max", "上限");
        addENCN("gtecore.player_exp_status.experience", "\n  Experience: ", "\n  经验: ");
        addENCN("gtecore.player_exp_status.experience_next", " for next level", " 升级");
        addENCN("gtecore.player_exp_status.progress", "\n  Progress: ", "\n  升级进度: ");
        addENCN("gtecore.player_exp_status.upgrade_institution", "\n  Enhance Iife Intensity to upgrade", "\n  提升生命强度以升级");
        addENCN("gtecore.player_exp_status.body_name", "Life Intensity", "生命强度");
        addENCN("gtecore.player_exp_status.health_name", "Physique", "体格");
        addENCN("gtecore.player_exp_status.attack_name", "Strength", "肌肉");
        addENCN("gtecore.player_exp_status.open", "ExperienceSystemOpened", "经验系统已开启");
        addENCN("gtecore.player_exp_status.close", "ExperienceSystemClosed", "经验系统已关闭");
        addENCN("gtecore.player_exp_status.get_experience", "you got %s point of %s experience", "你获得了%s点%s经验");

        addENCN("gtecore.behaviour.grass_harvest.description", GOLD + "Greatly" + RESET + " increase the probability of wheat seed dropping", GOLD + "极大" + RESET + "地提升小麦种子掉落概率");
        addENCN("gtecore.behaviour.grass_harvest.description2", "Right click to harvest", "右键以收割");
        addENCN("gtecore.xaero_waypoint_set", "Ore Vein", "矿脉");
    }

    public static void enInitialize(LanguageProvider provider) {
        init();
        MachineLang.init();
        BlockLang.init();
        ItemLang.init();
        LANGS.forEach((k, v) -> {
            if (v.en == null) return;
            provider.add(k, v.en);
        });
    }

    public static void cnInitialize(SimplifiedChineseLanguageProvider provider) {
        LANGS.forEach((k, v) -> {
            if (v.cn == null) return;
            provider.add(k, v.cn);
        });
    }

    public static void twInitialize(TraditionalChineseLanguageProvider provider) {
        LANGS.forEach((k, v) -> {
            if (v.cn == null) return;
            provider.add(k, ChineseConverter.convert(v.cn));
        });
    }

    public record ENCN(String en, String cn) {

        @Override
        public boolean equals(Object o) {
            if (o instanceof ENCN encn) {
                return encn.en.equals(en) && encn.cn.equals(cn);
            }
            return false;
        }
    }

    public record ENCNS(String[] ens, String[] cns) {

        @Override
        public boolean equals(Object o) {
            if (o instanceof ENCNS encn) {
                return Arrays.equals(encn.ens, ens) && Arrays.equals(encn.cns, cns);
            }
            return false;
        }

        public int length() {
            return ens.length;
        }
    }
}
