/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.device;

import java.util.Hashtable;
import java.util.UUID;
import org.osgi.framework.BundleContext;
import static org.osgi.framework.Constants.SERVICE_PID;
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
    
    private ServiceRegistration register = null;

    public AbstractDevice(String category, String pid) {
        setCategory(category);
        setPid(pid);
    }
    
    @Override
    public void register(BundleContext bc) {
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

}
