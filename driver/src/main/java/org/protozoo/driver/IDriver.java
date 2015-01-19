/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventHandler;

/**
 *
 * @author wolfgang
 */
public interface IDriver extends org.osgi.service.device.Driver, EventHandler {

    public void register(BundleContext bc);
    public void unregister();
    
    public BundleContext getContext();

    public String getFilter();
    
}
