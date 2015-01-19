/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.device.internal;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;
import org.protozoo.device.Pinger;
import org.protozoo.device.impl.PingerImpl;

/**
 *
 * @author wolfgang
 */
public class PingerFactory implements ManagedServiceFactory {

    BundleContext context;
    HashMap<String, Pinger> pingers = new HashMap<>();

    public void register(BundleContext context) {
        this.context = context;

        Hashtable local = new Hashtable();
        local.put(Constants.SERVICE_PID, "org.protozoo.device.pinger");
        context.registerService(ManagedServiceFactory.class.getName(), this, local);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updated(String pid, Dictionary<String, ?> properties) throws ConfigurationException {
        Pinger pinger = (Pinger) pingers.get(pid);
        if (pinger == null) {
            pinger = new PingerImpl();
            pinger.register(context);
            pingers.put(pid, pinger);
        }
        //float frequency = getFloat(config, "frequency", 1);
        //pinger.setFrequency(frequency);
    }

    @Override
    public void deleted(String pid) {
        Pinger pinger = (Pinger) pingers.get(pid);
        if (pinger != null) {
            pingers.remove(pid);
            pinger.unregister();
        }
    }

}
