/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.device.internal;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.protozoo.device.Pinger;
import org.protozoo.device.impl.PingerImpl;

/**
 *
 * @author wolfgang
 */
public class PingerFactory implements ManagedServiceFactory {

    static final String FACTORY_NAME = "pinger.factory";
    
    BundleContext context;
    //HashMap<String, Pinger> pingers = new HashMap<>();
    Dictionary<String, ?> configuration;
    Map existingServices = new HashMap();

    public void register(BundleContext context) {
        this.context = context;

        /*
        ServiceReference refconfig = context.getServiceReference(ConfigurationAdmin.class.getName());
        ConfigurationAdmin configurationAdmin = (ConfigurationAdmin) context.getService(refconfig);
        
        if (configurationAdmin == null) {
            return;
        }
        
        Hashtable local = new Hashtable();
        local.put(Constants.SERVICE_PID, Pinger.class.getName());
        context.registerService(ManagedServiceFactory.class.getName(), this, local);
        */
    }

    @Override
    public void updated(String pid, Dictionary<String, ?> properties) throws ConfigurationException {
        
        System.out.println("PingerFactory: updated");
        
        // invoked when a new configuration dictionary is assigned to service 'pid'. 
        if (existingServices.containsKey(pid)) {  //the service already exists

            Pinger service = (Pinger) existingServices.get(pid);
            service.configure(properties);
        } else { //configuration dictionary for a new service

            Pinger service = createNewPingerInstance();
            service.configure(properties);
            existingServices.put(pid, service);
        }
    }
    
    @Override
    public void deleted(String pid) {

        System.out.println("PingerFactory: deleted " + pid);

        // invoked when the service 'pid' is deleted
        existingServices.remove(pid);

//        Pinger pinger = (Pinger) pingers.get(pid);
//        if (pinger != null) {
//            pingers.remove(pid);
//            pinger.unregister();
//        }
    }

    @Override
    public String getName() 
    {
        return FACTORY_NAME;
    }
    
    protected float getFloat(String key, float def) {
        if (configuration != null) {
            Object val = configuration.get(key);
            if (val instanceof Number) {
                return ((Number) val).floatValue();
            } else if (val != null) {
                return Float.parseFloat(val.toString());
            }
        }
        
        return def;
    }

    private Pinger createNewPingerInstance() {

        System.out.println("PingerFactory: create new Pinger");
        
        Pinger p = new PingerImpl();
        p.register(context);
        
        return p;
    }
}
