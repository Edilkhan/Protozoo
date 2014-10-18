/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.cxf.rest;

import java.util.Collection;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.Factory;

/**
 *
 * @author wolfgang
 */
public class DeviceResourceImpl implements DeviceResource {

    private final Factory factory = null;
    
    @Override
    public Collection<Item> getAllDevices() {
        return factory.getDatabase().getDevices();
    }

    @Override
    public IDevice getDevice(String id) {
        return factory.getDatabase().getDevice(id);
    }
        
}
