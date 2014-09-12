/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import org.woz.protozoa.model.api.Location;
import org.woz.protozoa.model.api.Factory;

/**
 *
 * @author wolfgang
 */
public class FactoryImpl implements Factory {

    @Override
    public Location createLocation(String name) {
        Location testloc = new GenericLocation(name);
        
        HashDB.addLocation(testloc);
        
        return testloc;
    }

    @Override
    public boolean destroyLocation(Location location) {
        return HashDB.removeLocation(location.getName());
    }
    
    @Override
    public Location retrieveLocation(String name) {
        return HashDB.retrieveLocation(name);
    }
}
