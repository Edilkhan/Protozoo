/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

import org.woz.protozoa.model.HashDB;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.spi.Location;

/**
 * Component implementing the Location service
 * 
 * @author wolfgang
 */
public class LocationServiceImpl implements LocationService {
    
    HashDB database = new HashDB();

    @Override
    public Location getLocation(String name) {
        if (database != null) {
            return database.getLocation(name);
        }
        return null;
    }

    @Override
    public Location createLocation(String name) {
        return null;
    }
    
    @Override
    public Location updateLocation(Location location, String name, String description, State state, Type type) {
        return null;
    }
    
    public void startUp() {
        System.out.println("====>>>> Starting Location server");
    }
}
