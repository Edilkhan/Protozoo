/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device.impl;

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
    
    public PingerImpl() {
        super(CATEGORY, PID);
        addCapability(ON, OFF, PING);
    }
}
