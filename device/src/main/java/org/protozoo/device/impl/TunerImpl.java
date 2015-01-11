/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device.impl;

import org.osgi.framework.BundleContext;
import org.protozoo.device.AbstractDevice;
import org.protozoo.system.core.item.CapableItem;
import org.protozoo.device.Tuner;
import static org.protozoo.system.core.type.Capability.CHANNEL_DOWN;
import static org.protozoo.system.core.type.Capability.CHANNEL_UP;
import static org.protozoo.system.core.type.Capability.OFF;
import static org.protozoo.system.core.type.Capability.ON;
import static org.protozoo.system.core.type.Capability.VOLUME_DOWN;
import static org.protozoo.system.core.type.Capability.VOLUME_UP;
import static org.protozoo.system.core.type.State.NO_DRIVER;

/**
 *
 * @author wolfgang
 */
public class TunerImpl extends AbstractDevice implements Tuner {

    public TunerImpl() {
        super("", "");
        addCapability(ON, OFF, VOLUME_UP, VOLUME_DOWN, CHANNEL_UP, CHANNEL_DOWN);
    }

    @Override
    public void noDriverFound() {
        setState(NO_DRIVER);
    }
}
