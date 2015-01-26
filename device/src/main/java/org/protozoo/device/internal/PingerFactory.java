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
    HashMap<String, Pinger> pingers = new HashMap<>();
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
        
        configuration = properties;
        
        Pinger pinger = (Pinger) pingers.get(pid);
        if (pinger == null) {
            pinger = new PingerImpl();
            pinger.register(context);
            pingers.put(pid, pinger);
        }

        float frequency = getFloat("frequency", 1.0f);
        pinger.setFrequency(frequency);
    }
    
    @Override
    public void deleted(String pid) {
        Pinger pinger = (Pinger) pingers.get(pid);
        if (pinger != null) {
            pingers.remove(pid);
            pinger.unregister();
        }
    }

    public void updated(String pid, Dictionary dictionary) throws ConfigurationException 
    {
        // invoked when a new configuration dictionary is assigned
        // to service 'pid'. 
        if (existingServices.containsKey(pid))  //the service already exists
        {
            MyService service = (MyService) existingServices.get(pid);
            service.configure(dictionary);
        }
        else //configuration dictionary for a new service
        {
            MyService service = createNewServiceInstance();
            service.configure(dictionary);
            existingServices.put(pid, service);
        }
    }

    public void deleted(String pid) 
    {
        // invoked when the service 'pid' is deleted
        existingServices.remove(pid);
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

}
