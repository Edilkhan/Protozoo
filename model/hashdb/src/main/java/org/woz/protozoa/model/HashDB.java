/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import java.util.HashMap;
import org.woz.protozoa.core.item.Item;
import static org.woz.protozoa.core.type.State.ACTIVE;
import static org.woz.protozoa.core.type.Type.PHYSICAL;
import org.woz.protozoa.model.api.Location;

/**
 *
 * @author wos
 */
public class HashDB extends HashMap<String, Item> {
       
    private static final HashDB database = new HashDB();
    private static boolean initialized = false;
    
    public static HashDB getDatabase() {
        if (!initialized) {
            initDB();
        }
        return database;
    }
        
    public Location getLocation(String name) {
        
        Object o = database.get(name);
        if (o != null) {
            if (o instanceof Location) {
                return (Location)o;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private static void initDB() {
        Location home = new GenericLocation("Home");
        home.setDescription("Home sweet home");
        home.setState(ACTIVE);
        home.setType(PHYSICAL);
        database.put(home.getName(), home);
        initialized = true;
    }
    
    public static Location addLocation(Location location) {
        return (Location)database.put(location.getName(), location);
    }

    public static boolean removeLocation(String name) {
        return database.remove(name) != null;
    }
    
    public static Location retrieveLocation(String name) {
        return (Location)database.get(name);
    }
}
