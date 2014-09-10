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
        return HashDB.getDatabase().addLocation(new GenericLocation(name));
    }

    @Override
    public boolean destroyLocation(Location location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
