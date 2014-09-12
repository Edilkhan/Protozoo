/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import org.woz.protozoa.model.api.Database;
import org.woz.protozoa.model.api.Factory;
import org.woz.protozoa.model.api.Location;

/**
 *
 * @author wolfgang
 */
public class FactoryImpl implements Factory {

    public static final Database database = new HashDB();
    
    @Override
    public Database getDatabase() {
        return database;
    }
    
    @Override
    public Location createLocation(String name) {
        return createLocation(name, null);
    }
    
    @Override
    public Location createLocation(String name, String description) {
        return new GenericLocation(name, description);
    }
        
}
