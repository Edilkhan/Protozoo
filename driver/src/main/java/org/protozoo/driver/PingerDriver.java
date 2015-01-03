/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.driver;

import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import static org.osgi.service.device.Constants.DEVICE_CATEGORY;
import static org.osgi.service.device.Constants.DRIVER_ID;
import static org.osgi.service.device.Device.MATCH_NONE;
import org.osgi.service.device.Driver;
import org.protozoo.core.type.State;
import org.protozoo.device.Pinger;

/**
 *
 * @author wolfgang
 */
public class PingerDriver implements Driver {

    static final String PINGER_DEVICE_CATEGORY = "pinger";
    static final String PINGER_DRIVER_ID = "my.driver.pinger";
    private BundleContext bc = null;
    private ServiceRegistration sReg = null;

    public void register(BundleContext bc) {

        this.bc = bc;

        Hashtable props = new Hashtable();
        props.put(DRIVER_ID, PINGER_DRIVER_ID);
        sReg = bc.registerService(Driver.class.getName(), this, props);
    }

    public void unregister() {
        if (sReg != null) {
            sReg.unregister();
        }
    }

    // Methods inherited from Driver
    @Override
    public int match(ServiceReference sRef) throws Exception {
        if (sRef != null) {
            String deviceCategory = (String) sRef.getProperty(DEVICE_CATEGORY);
            if (deviceCategory.equals(PINGER_DEVICE_CATEGORY)) {
                return 1;
            }
        }
        return MATCH_NONE;
    }

    @Override
    public String attach(ServiceReference sRef) throws Exception {
        if (sRef != null) {
            Pinger device = (Pinger) bc.getService(sRef);
            dump("Initial State = " + device.getState());
            device.setState(State.ACTIVE);
        }
        
        return null;
    }

    // Prints the specified message to the system output
    private void dump(String msg) {
        System.out.println("[MY PINGER DRIVER] " + msg);
    }
}
