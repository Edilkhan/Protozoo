/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.Repository;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
public class DeviceResourceImpl implements DeviceResource {
    
    static Repository repo = new MySQLRepository();
    
    
    @Override
    public String getAllDevices() {
        return "";
    }

    @Override
    public String getDevice(String id) {
        IDevice dev = repo.getDevice(id);

        return dev.toString();
    }
        
}
