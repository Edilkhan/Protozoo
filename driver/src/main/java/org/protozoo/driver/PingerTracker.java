/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.device.Constants;
import org.osgi.util.tracker.ServiceTracker;
import org.protozoo.device.Pinger;
import org.protozoo.system.core.type.Capability;
import org.protozoo.system.core.type.State;
import static org.protozoo.system.core.type.State.ACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wos
 */
public class PingerTracker extends ServiceTracker implements Pinger, Constants {

    private final Logger logger = LoggerFactory.getLogger(PingerTracker.class);
    private ServiceRegistration registration;

    PingerTracker(BundleContext c, ServiceReference r) {
        super(c, r, null);
        open();
    }

    @Override
    public Object addingService(ServiceReference ref) {
        
        logger.debug("addingService: " + ref.toString());
        
        Pinger pinger = (Pinger)context.getService(ref);
        pinger.setState(ACTIVE);
        
        registration = context.registerService(Pinger.class.getName(), this, null);
        
        return pinger;
    }

    @Override
    public void removedService(ServiceReference ref, Object service) {

        registration.unregister();
        context.ungetService(ref);

    }

    //... methods for javax.comm.SerialPort that are
    //... converted to underlying WidgetDevice

    @Override
    public void register(BundleContext bc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unregister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPid(String pid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void noDriverFound() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCapability(Capability c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCapability(Collection<Capability> clist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCapability(Capability... clist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeCapability(Capability c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasCapability(Capability c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Capability> getCapabilities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(State s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
