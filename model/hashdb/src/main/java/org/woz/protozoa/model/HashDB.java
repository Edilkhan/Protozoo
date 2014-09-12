/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import java.util.Collection;
import java.util.HashMap;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.model.api.Database;
import org.woz.protozoa.model.api.Location;

/**
 *
 * @author wos
 */
public class HashDB extends HashMap<String, Item> implements Database {
                   
    @Override
    public Location getLocation(String name) {
        
        return (Location)get(name);
    }

    @Override
    public Location addLocation(Location newloc) {

        if (newloc != null) {
            if (newloc.getName() != null && !newloc.getName().isEmpty()) {
                return (Location)put(newloc.getName(), newloc);
            } else {
                throw new IllegalArgumentException("Add location with empty name or null");
            }
        } else {
            throw new IllegalArgumentException("Add location with null parameter");
        }
    }

    @Override
    public boolean removeLocation(String name) {
        
        return (remove(name) != null);
        
    }

    @Override
    public Collection<Item> getLocations() {
        
        return (Collection<Item>)this.values();
        
    }
    
    
}
