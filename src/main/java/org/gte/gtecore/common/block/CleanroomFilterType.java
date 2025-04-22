package org.gte.gtecore.common.block;

import org.gte.gtecore.api.machine.GTECleanroomType;

import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public final class CleanroomFilterType implements IFilterType {

    public static final CleanroomFilterType FILTER_CASING_LAW = new CleanroomFilterType("law_filter_casing", GTECleanroomType.LAW_CLEANROOM);

    private final String name;
    @Getter
    private final CleanroomType cleanroomType;

    private CleanroomFilterType(String name, CleanroomType cleanroomType) {
        this.name = name;
        this.cleanroomType = cleanroomType;
    }

    @NotNull
    @Override
    public String getSerializedName() {
        return name;
    }

    @NotNull
    @Override
    public String toString() {
        return name;
    }
}
