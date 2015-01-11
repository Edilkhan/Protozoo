/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.device.Constants;
import org.osgi.util.tracker.ServiceTracker;
import org.protozoo.device.IDevice;

/**
 *
 * @author wos
 */
public class DriverTracker extends ServiceTracker implements Constants {

    ServiceRegistration registration;

    DriverTracker(BundleContext c, ServiceReference r) {
        super(c, r, null);
        open();
    }

    @Override
    public Object addingService(ServiceReference ref) {
        IDevice dev = (IDevice) context.getService(ref);
        registration = context.registerService(javax.comm.SerialPort.class.getName(), this, null);
        return dev;
    }

    @Override
    public void removedService(ServiceReference ref,
            Object service) {
        registration.unregister();
        context.ungetService(ref);
    }

    //... methods for javax.comm.SerialPort that are
    //... converted to underlying WidgetDevice
}
