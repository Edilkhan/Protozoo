/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.device;

import java.util.Hashtable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleContext;
import static org.osgi.framework.Constants.SERVICE_PID;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import static org.osgi.service.device.Constants.DEVICE_CATEGORY;
import static org.osgi.service.device.Constants.DEVICE_SERIAL;
import org.osgi.service.device.Device;
import org.protozoo.system.core.item.CapableItem;
import static org.protozoo.system.core.type.State.NO_DRIVER;

/**
 *
 * @author wos
 */
public abstract class AbstractDevice extends CapableItem implements IDevice {

    private String category;
    private String pid;
    private BundleContext bc;
    
    private ServiceRegistration register = null;
    private ServiceReference listener = null;

    public AbstractDevice(String category, String pid) {
        setCategory(category);
        setPid(pid);
    }
    
    @Override
    public void register(BundleContext bc) {
        this.bc = bc;
        
        Hashtable deviceProps = new Hashtable();
        deviceProps.put(DEVICE_CATEGORY, getCategory());
        deviceProps.put(DEVICE_SERIAL, UUID.randomUUID());
        deviceProps.put(SERVICE_PID, getPid());

        register = bc.registerService(new String[]{Device.class.getName(), this.getClass().getName()}, this, deviceProps);
    }

    @Override
    public void unregister() {
        if (register != null) {
            register.unregister();
        }
    }

    @Override
    public void noDriverFound() {
        setState(NO_DRIVER);
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public final void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getPid() {
        return pid;
    }

    @Override
    public final void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public void setObserver(ServiceReference reference) {
        try {
            listener = reference;
            Object service = bc.getService(reference);
            
            System.out.println("Keys: " + reference.getPropertyKeys());
            
            bc.addServiceListener(this, "(" + service.getClass().getName() + ")");
        } catch (InvalidSyntaxException ex) {
            Logger.getLogger(AbstractDevice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void serviceChanged(ServiceEvent event) {
        if (event.getType() == ServiceEvent.UNREGISTERING) {
            bc.removeServiceListener(this);
            listener = null;
        }
    }

}
