/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;

/**
 * Component implementing the Location service
 * 
 * @author wolfgang
 */
@Component
@Provides
public class LocationServiceImpl implements LocationService {

    @Override
    public Location createLocation(String name) {
        return null;
    }
    
    @Override
    public Location updateLocation(Location location, String name, String description, State state, Type type) {
        return null;
    }
}
