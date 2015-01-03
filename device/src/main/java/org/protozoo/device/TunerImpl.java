/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device;

import org.protozoo.core.item.CapableItem;
import static org.protozoo.core.type.Capability.CHANNEL_DOWN;
import static org.protozoo.core.type.Capability.CHANNEL_UP;
import static org.protozoo.core.type.Capability.OFF;
import static org.protozoo.core.type.Capability.ON;
import static org.protozoo.core.type.Capability.VOLUME_DOWN;
import static org.protozoo.core.type.Capability.VOLUME_UP;
import static org.protozoo.core.type.State.NO_DRIVER;

/**
 *
 * @author wolfgang
 */
public class TunerImpl extends CapableItem implements Tuner {

    public TunerImpl() {
        addCapability(ON, OFF, VOLUME_UP, VOLUME_DOWN, CHANNEL_UP, CHANNEL_DOWN);
    }

    @Override
    public void noDriverFound() {
        setState(NO_DRIVER);
    }

}
