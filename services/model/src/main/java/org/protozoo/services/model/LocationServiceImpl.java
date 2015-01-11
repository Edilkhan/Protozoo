/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.protozoo.services.model;

import org.osgi.service.component.annotations.Component;
import org.protozoo.system.core.type.State;
import org.protozoo.system.core.type.Type;
import org.protozoo.model.api.ILocation;

/**
 * Component implementing the ILocation service
 * 
 * @author wolfgang
 */
@Component
public class LocationServiceImpl implements LocationService {

    @Override
    public ILocation createLocation(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ILocation getLocation(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ILocation updateLocation(String name, String description, State state, Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLocation(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
