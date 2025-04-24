package org.gte.gtecore.api;

import static net.minecraft.ChatFormatting.*;

public class GTEValues {

    // Dyson Sphere Data
    public static final String GALAXY = "g";
    public static final String DYSON_LIST = "l";
    public static final String DYSON_COUNT = "c";
    public static final String DYSON_DAMAGE = "d";
    public static final String DYSON_USE = "u";

    // Infinity Cell Data
    public static final String INFINITY_CELL_LIST = "l";
    public static final String INFINITY_CELL_UUID = "u";
    public static final String INFINITY_CELL_DATA = "d";
    public static final String INFINITY_CELL_KEYS = "k";
    public static final String INFINITY_CELL_AMOUNTS = "a";

    // Wireless Energy Data
    public static final String WIRELESS_ENERGY_UUID = "u";
    public static final String WIRELESS_ENERGY_STORAGE = "s";
    public static final String WIRELESS_ENERGY_CAPACITY = "c";
    public static final String WIRELESS_ENERGY_RATE = "r";
    public static final String WIRELESS_ENERGY_LOSS = "l";
    public static final String WIRELESS_ENERGY_DIMENSION = "d";
    public static final String WIRELESS_ENERGY_POS = "p";

    // Planets Travel Data
    public static final String PLAYER_LIST = "l";
    public static final String PLAYER_UUID = "u";
    public static final String PLANET_LIST = "p";
    public static final String PLANET_NAME = "n";

    // Tier Type
    public static final String STELLAR_CONTAINMENT_TIER = "s_c";
    public static final String POWER_MODULE_TIER = "p_m";
    public static final String COMPONENT_ASSEMBLY_CASING_TIER = "c_a";
    public static final String GLASS_TIER = "g_b";
    public static final String MACHINE_CASING_TIER = "m_c";
    public static final String GRAVITON_FLOW_TIER = "g_f";
    public static final String INTEGRAL_FRAMEWORK_TIER = "i_f";
    public static final String COMPUTER_CASING_TIER = "c_c";
    public static final String COMPUTER_HEAT_TIER = "c_h";

    // Drone State
    public static final String REMOVING_ASH = "gtecore.drone.removing_ash";
    public static final String MAINTAINING = "gtecore.drone.maintaining";

    public static final int[] MANA = new int[] { 1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864 };
    public static final long[] VAEX = { 7L, 30L, 120L, 480L, 1920L, 7680L, 30720L, 122880L, 491520L, 1966080L, 7864320L, 31457280L, 125829120L, 503316480L, 2013265920L, 8053063680L, 32212254720L, 128849018880L, 515396075520L, 2061584302080L, 8246337208320L, 32985348833280L, 131941395333120L, 527765581332480L, 2111062325329920L, 8444249301319680L, 33776997205278720L, 135107988821114880L, 540431955284459520L, 2161727821137838080L, 8646911284551352319L };

    public static final String[] MANAN = new String[] {
            "Primitive",
            "Enlighten",
            "Apprentice",
            "Elemental",
            "Sorcerer",
            "Arcane",
            "Magisters",
            "Mysteries",
            "Philosopher",
            "Regards",
            "Awaken",
            "Prosperity",
            "End",
            "Perpetual" };

    public static final String[] MANACN = new String[] {
            "原始",
            "启蒙",
            "学徒",
            "精灵",
            "法师",
            "奥术",
            "导师",
            "秘仪",
            "贤者",
            "启示",
            "觉醒",
            "黄金",
            "终焉",
            "永恒" };

    public static final String[] VLVHCN = new String[] {
            "原始",
            "基础",
            AQUA + "进阶",
            GOLD + "进阶",
            DARK_PURPLE + "进阶",
            BLUE + "精英",
            LIGHT_PURPLE + "精英",
            RED + "精英",
            DARK_AQUA + "终极",
            DARK_RED + "史诗",
            GREEN + "史诗",
            DARK_GREEN + "史诗",
            YELLOW + "史诗",
            BLUE.toString() + BOLD + "传奇",
            RED.toString() + BOLD + "MAX" };

    public static final String[] VOLTAGE_NAMESCN = new String[] { "超低压", "低压", "中压", "高压", "超高压", "强导压", "剧差压", "零点压", "极限压", "极高压", "极超压", "极巨压", "超极限压", "过载压", "终压" };

    public static final String[] VNFR = new String[] {
            DARK_GRAY + "ULV" + RESET,
            GRAY + "LV" + RESET,
            AQUA + "MV" + RESET,
            GOLD + "HV" + RESET,
            DARK_PURPLE + "EV" + RESET,
            BLUE + "IV" + RESET,
            LIGHT_PURPLE + "LuV" + RESET,
            RED + "ZPM" + RESET,
            DARK_AQUA + "UV" + RESET,
            DARK_RED + "UHV" + RESET,
            GREEN + "UEV" + RESET,
            DARK_GREEN + "UIV" + RESET,
            YELLOW + "UXV" + RESET,
            BLUE.toString() + BOLD + "OpV" + RESET,
            RED.toString() + BOLD + "MAX" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "1" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "2" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "3" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "4" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "5" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "6" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "7" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "8" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "9" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "10" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "11" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "12" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "13" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "14" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "15" + RESET,
            RED.toString() + BOLD + "M" + GREEN + BOLD + "A" + BLUE + BOLD + "X" + YELLOW + BOLD + "+" + RED + BOLD + "16" + RESET,
    };
}
