package org.gte.gtecore.api.machine.part;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;

public interface GTEPartAbility {

    PartAbility NEUTRON_ACCELERATOR = new PartAbility("neutron_accelerator");
    PartAbility THREAD_HATCH = new PartAbility("thread_hatch");
    PartAbility ACCELERATE_HATCH = new PartAbility("accelerate_hatch");
    PartAbility ITEMS_INPUT = new PartAbility("items_input");
    PartAbility ITEMS_OUTPUT = new PartAbility("items_output");
    PartAbility DRONE_HATCH = new PartAbility("drone_hatch");
    PartAbility INPUT_MANA = new PartAbility("input_mana");
    PartAbility OUTPUT_MANA = new PartAbility("output_mana");
    PartAbility EXTRACT_MANA = new PartAbility("extract_mana");
    PartAbility COMPUTING_COMPONENT = new PartAbility("computing_component");
    PartAbility ExDATA_ACCESS = new PartAbility("ex_data_access");
}
