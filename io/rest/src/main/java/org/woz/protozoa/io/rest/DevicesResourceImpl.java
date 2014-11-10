/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.model.api.Repository;
import org.woz.protozoa.model.mysql.Device;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
public class DevicesResourceImpl implements DevicesResource {
    
    protected final Logger log = LoggerFactory.getLogger(DevicesResourceImpl.class);

    static MySQLRepository repo = new MySQLRepository();
      
    @Override
    public Collection<Device> getDevices() {
        Collection result = repo.getDevices();
        
        return result;
    }

    @Override
    public Device getDevice(String name) {
        log.info("REST getDevice called for id: " + name);
                
        Device dev = (Device) repo.getDevice(name);

        log.info("REST returns: " + dev);
        
        return dev;
    }

}
