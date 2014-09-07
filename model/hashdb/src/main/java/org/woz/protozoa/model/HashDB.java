/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import java.util.HashMap;
import static org.woz.protozoa.core.type.State.ACTIVE;
import static org.woz.protozoa.core.type.Type.PHYSICAL;
import org.woz.protozoa.model.api.Location;

/**
 *
 * @author wos
 */
public class HashDB {
    
    private final HashMap<String, Object> internaldb = new HashMap<>();
    
    private static final HashDB database = new HashDB();
    
    public static HashDB getDatabase() {
        return database;
    }
    
    public HashDB() {        
        System.out.println("HashDB constructor");
        initDB();
    }
    
    public Location getLocation(String name) {
        if (internaldb.isEmpty()) {
            initDB();
        }
        
        Object o = internaldb.get(name);
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

    private void initDB() {
        Location home = new GenericLocation("Home");
        home.setDescription("Home sweet home");
        home.setState(ACTIVE);
        home.setType(PHYSICAL);
        internaldb.put(home.getName(), home);

        System.out.println("HashDB initialized");
    }
    
    public Location addLocation(Location location) {
        return (Location)internaldb.put(location.getName(), location);
    }
}
