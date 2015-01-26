/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device.impl;

import org.osgi.framework.BundleContext;
import org.protozoo.device.AbstractDevice;
import org.protozoo.device.Pinger;
import static org.protozoo.system.core.type.Capability.OFF;
import static org.protozoo.system.core.type.Capability.ON;
import static org.protozoo.system.core.type.Capability.PING;

/**
 *
 * @author wolfgang
 */
public class PingerImpl extends AbstractDevice implements Pinger {

    private static final String CATEGORY = "pinger";
    private static final String PID = Pinger.class.getName();

    private float frequency = 1.0f;
    
    public PingerImpl() {
        super(CATEGORY, PID);
        addCapability(ON, OFF, PING);
    }

    @Override
    public void register(BundleContext bc) {

        super.register(bc);
        
    }

    @Override
    public void unregister() {

        super.unregister();

    }

    @Override
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    @Override
    public float getFrequency() {
        return this.frequency;
    }
}
