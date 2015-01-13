/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import static org.osgi.service.device.Constants.DEVICE_CATEGORY;
import static org.osgi.service.device.Constants.DRIVER_ID;
import static org.osgi.service.device.Device.MATCH_NONE;
import org.protozoo.device.IDevice;
import org.protozoo.system.core.type.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wolfgang
 */
public abstract class AbstractDriver implements Driver, ServiceListener {

    private final Logger logger = LoggerFactory.getLogger(Driver.class);

    private BundleContext bc = null;
    private ServiceRegistration sReg = null;

    private String id;
    private String category;

    public AbstractDriver(String id, String category) {
        setId(id);
        setCategory(category);
    }

    @Override
    public void register(BundleContext bc) {

        this.bc = bc;

        Hashtable props = new Hashtable();
        props.put(DRIVER_ID, id);

        if (bc != null) {
            sReg = bc.registerService(org.osgi.service.device.Driver.class.getName(), this, props);
            System.out.println("Driver registered as a service: " + sReg);
        } else {
            logger.error("Register driver service failed, bundle context is null");
        }
    }

    @Override
    public void unregister() {
        if (sReg != null) {
            sReg.unregister();
        }
    }

    @Override
    public int match(ServiceReference reference) throws Exception {
        if (reference != null) {
            logger.info("Matching driver with " + reference.toString());

            String deviceCategory = (String) reference.getProperty(DEVICE_CATEGORY);
            if (deviceCategory.equals(category)) {
                return 1;
            }
        }
        return MATCH_NONE;
    }

    @Override
    public String attach(ServiceReference reference) throws Exception {
        if (reference != null) {
            IDevice device = (IDevice) bc.getService(reference);

            if (device != null) {
                System.out.println("Activating device: " + device.toString());
                device.setState(State.ACTIVE);
                System.out.println("Trying to set observer: " + sReg.getReference().toString());
                device.setObserver(sReg.getReference());
            } else {
                System.out.println("Failed activating device = null");
            }
                        
            //bc.addServiceListener(this);
        }

        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void serviceChanged(ServiceEvent event) {
        if (event != null) {
            String eventname = "UNKNOWN";

            switch (event.getType()) {
                case 1:
                    eventname = "REGISTERED";
                    break;
                case 2:
                    eventname = "MODIFIED";
                    break;
                case 3:
                    eventname = "MODIFIED_ENDMATCH";
                    break;
                case 4:
                    eventname = "UNREGISTERING";
                    break;
            }

            System.out.println("Event received: " + eventname);

            ServiceReference ref = event.getServiceReference();
            if (ref != null) {
                IDevice dev = (IDevice) bc.getService(ref);

                System.out.println("Device: " + dev.getCategory() + ", " + dev.getPid());
            }
        }
    }
}
