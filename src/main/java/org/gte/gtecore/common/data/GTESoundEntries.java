package org.gte.gtecore.common.data;

import com.gregtechceu.gtceu.api.sound.SoundEntry;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public interface GTESoundEntries {

    SoundEntry DTPF = REGISTRATE.sound("dtpf").build();
    SoundEntry FUSIONLOOP = REGISTRATE.sound("fusionloop").build();

    static void init() {}
}
