/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device.impl;

import java.util.Hashtable;
import java.util.UUID;
import org.osgi.framework.BundleContext;
import static org.osgi.framework.Constants.SERVICE_PID;
import org.osgi.framework.ServiceRegistration;
import static org.osgi.service.device.Constants.DEVICE_CATEGORY;
import static org.osgi.service.device.Constants.DEVICE_SERIAL;
import org.osgi.service.device.Device;
import org.protozoo.core.item.CapableItem;
import org.protozoo.device.Pinger;
import static org.protozoo.core.type.Capability.OFF;
import static org.protozoo.core.type.Capability.ON;
import static org.protozoo.core.type.Capability.PING;
import static org.protozoo.core.type.State.NO_DRIVER;

/**
 *
 * @author wolfgang
 */
public class PingerImpl extends CapableItem implements Pinger {

    ServiceRegistration sReg = null;

    public PingerImpl() {
        addCapability(ON, OFF, PING);
    }

    @Override
    public void noDriverFound() {
        setState(NO_DRIVER);
    }

    @Override
    public void register(BundleContext bc) {
        Hashtable deviceProps = new Hashtable();
        deviceProps.put(DEVICE_CATEGORY, "pinger");
        deviceProps.put(DEVICE_SERIAL, UUID.randomUUID());
        deviceProps.put(SERVICE_PID, "my.device.pinger");

        sReg = bc.registerService(new String[]{Device.class.getName(), Pinger.class.getName()}, this, deviceProps);
    }

    @Override
    public void unregister() {
        if (sReg != null) {
            sReg.unregister();
        }
    }

    // Prints the specified message to the system output
    private void dump(String msg) {
        System.out.println("[PINGER DEVICE] " + msg);
    }
}
