/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.util.Collection;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.Repository;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
@Produces(MediaType.APPLICATION_JSON)
public class DeviceResourceImpl implements DeviceResource {
    
    protected final Logger log = LoggerFactory.getLogger(LocationResourceImpl.class);

    static Repository repo = new MySQLRepository();
      
    @Override
    public String getDevices() {
        Collection result = repo.getDevices();
        
        return result.toString();
    }

    @Override
    public IDevice getDevice(String id) {
        log.info("REST getDevice called...");
                
        IDevice dev = repo.getDevice(id);

        return dev;
    }

    
    
}
