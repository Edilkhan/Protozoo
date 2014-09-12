/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.api.Factory;
import org.woz.protozoa.model.api.Location;

/**
 * Component implementing the Location service
 * 
 * @author wolfgang
 */
public class LocationServiceImpl implements LocationService {
    
    private final Factory factory = null;

    @Override
    public Location createLocation(String name) {
        return factory.createLocation(name);
    }

    @Override
    public Location getLocation(String name) {
        return factory.getDatabase().getLocation(name);
    }

    @Override
    public Location updateLocation(String name, String description, State state, Type type) {
        Location location = getLocation(name);

        if (location != null) {
            location.setDescription(description);
            location.setState(state);
            location.setType(type);
            
            return location;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeLocation(String name) {
        return factory.getDatabase().removeLocation(name);
    }
    
}
