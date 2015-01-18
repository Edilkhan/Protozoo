/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.device;

import java.util.Observable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;
import org.osgi.service.device.Device;
import org.protozoo.system.core.type.Capable;
import org.protozoo.system.core.type.Stateful;

/**
 *
 * @author wos
 */
public interface IDevice extends Device, ServiceListener, Capable, Stateful {

    public void register(BundleContext bc);
    public void unregister();
    
    public void setCategory(String category);
    public String getCategory();
    
    public void setPid(String pid);
    public String getPid();

    public void setObserver(String serviceName, String filter);
    
}
