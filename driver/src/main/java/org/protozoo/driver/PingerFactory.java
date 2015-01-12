/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedServiceFactory;

/**
 *
 * @author wolfgang
 */
public class PingerFactory implements ManagedServiceFactory {

    Hashtable consoles = new Hashtable();
    Dictionary properties;
    BundleContext context;

    public void start(BundleContext context)
            throws Exception {
        this.context = context;
        Hashtable local = new Hashtable();
        local.put(Constants.SERVICE_PID, "org.protozoo.driver.console");
        context.registerService(
                ManagedServiceFactory.class.getName(),
                this,
                local);
        
        properties = new Hashtable();
        properties.put("port", 1234);
    }

    public void updated(String pid, Dictionary config) {
        Console console = (Console) consoles.get(pid);

        if (console == null) {
            console = new Console(context);
            consoles.put(pid, console);
        }

        int port = (int) config.get("port");

        console.setPort(port);
    }

    public void deleted(String pid) {
        Console console = (Console) consoles.get(pid);
        if (console != null) {
            consoles.remove(pid);
//            console.close();
        }
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
