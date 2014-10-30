/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

import org.osgi.service.component.annotations.Component;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.api.ILocation;

/**
 * Component implementing the ILocation service
 * 
 * @author wolfgang
 */
@Component
public class LocationServiceImpl implements LocationService {
    
    private final Factory factory = null;

    @Override
    public ILocation createLocation(String name) {
        return factory.createLocation(name);
    }

    @Override
    public ILocation getLocation(String name) {
        return factory.getDatabase().getLocation(name);
    }

    @Override
    public ILocation updateLocation(String name, String description, State state, Type type) {
        ILocation location = getLocation(name);

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
