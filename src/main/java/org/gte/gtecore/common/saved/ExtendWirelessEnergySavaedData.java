package org.gte.gtecore.common.saved;

import org.gte.gtecore.api.GTEValues;
import org.gte.gtecore.common.wireless.ExtendWirelessEnergyContainer;
import org.gte.gtecore.utils.GTEUtils;

import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;

import com.hepdd.gtmthings.api.misc.WirelessEnergyContainer;
import com.hepdd.gtmthings.data.WirelessEnergySavaedData;

import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;

public final class ExtendWirelessEnergySavaedData extends WirelessEnergySavaedData {

    public ExtendWirelessEnergySavaedData() {}

    public ExtendWirelessEnergySavaedData(CompoundTag tag) {
        super(tag);
    }

    @Override
    protected WirelessEnergyContainer readTag(CompoundTag engTag) {
        UUID uuid = engTag.getUUID(GTEValues.WIRELESS_ENERGY_UUID);
        String en = engTag.getString(GTEValues.WIRELESS_ENERGY_STORAGE);
        String ca = engTag.getString(GTEValues.WIRELESS_ENERGY_CAPACITY);
        BigInteger energy = new BigInteger(en.isEmpty() ? "0" : en);
        BigInteger capacity = new BigInteger(ca.isEmpty() ? "0" : ca);
        long rate = engTag.getLong(GTEValues.WIRELESS_ENERGY_RATE);
        int loss = engTag.getInt(GTEValues.WIRELESS_ENERGY_LOSS);
        GlobalPos bindPos = GTEUtils.readGlobalPos(engTag.getString(GTEValues.WIRELESS_ENERGY_DIMENSION), engTag.getLong(GTEValues.WIRELESS_ENERGY_POS));
        return new ExtendWirelessEnergyContainer(uuid, energy, rate, bindPos, capacity, loss);
    }

    @Override
    protected CompoundTag toTag(WirelessEnergyContainer c) {
        CompoundTag engTag = new CompoundTag();
        if (c instanceof ExtendWirelessEnergyContainer container) {
            BigInteger storage = container.getStorage();
            if (!Objects.equals(storage, BigInteger.ZERO)) {
                engTag.putString(GTEValues.WIRELESS_ENERGY_STORAGE, storage.toString());
            }
            BigInteger capacity = container.getCapacity();
            if (!Objects.equals(capacity, BigInteger.ZERO)) {
                engTag.putString(GTEValues.WIRELESS_ENERGY_CAPACITY, capacity.toString());
            }
            long rate = container.getRate();
            if (rate != 0) {
                engTag.putLong(GTEValues.WIRELESS_ENERGY_RATE, rate);
            }
            int loss = container.getLoss();
            if (loss != 0) {
                engTag.putInt(GTEValues.WIRELESS_ENERGY_LOSS, loss);
            }
            GlobalPos bindPos = container.getBindPos();
            if (bindPos != null) {
                engTag.putString(GTEValues.WIRELESS_ENERGY_DIMENSION, bindPos.dimension().location().toString());
                engTag.putLong(GTEValues.WIRELESS_ENERGY_POS, bindPos.pos().asLong());
            }
            if (!engTag.isEmpty()) {
                engTag.putUUID(GTEValues.WIRELESS_ENERGY_UUID, container.getUuid());
            }
        }
        return engTag;
    }
}
