/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

import java.util.HashMap;
import static org.woz.protozoa.services.model.State.ACTIVE;
import static org.woz.protozoa.services.model.Type.PHYSICAL;

/**
 *
 * @author wos
 */
public class HashDB {
    
    HashMap<String, Object> db = new HashMap<>();
    
    public HashDB() {        
        System.out.println("HashDB constructor");
        initDB();
    }
    
    public Location getLocation(String name) {
        if (db.isEmpty()) {
            initDB();
        }
        
        Object o = db.get(name);
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
        Location home = new LocationImpl("Home");
        home.setDescription("Home sweet home");
        home.setState(ACTIVE);
        home.setType(PHYSICAL);
        db.put(home.getName(), home);

        System.out.println("HashDB initialized");
    }
}
