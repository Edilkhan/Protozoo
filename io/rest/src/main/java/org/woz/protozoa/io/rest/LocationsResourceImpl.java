/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.rest;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.model.mysql.Location;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
public class LocationsResourceImpl implements LocationsResource {

    protected final Logger log = LoggerFactory.getLogger(LocationsResourceImpl.class);
    
    static MySQLRepository repo = new MySQLRepository();
    
    @Override
    public Collection<Location> getLocations() {
    
        Collection result = repo.getLocations();
        
        return result;
    }

    @Override
    public Location getLocation(String name) throws LocationNotFoundException {
        log.info("get location with name: " + name);
        
        Location loc = (Location) repo.getLocation(name);
        if (loc == null) {
            throw new LocationNotFoundException("Location with name not found");
        }
        
        log.info("returns: " + loc);
        
        return loc;
    }

    @Override
    public Location addLocation() {
        log.info("Create location ");
        
        return (Location) repo.addLocation("", "");
    }

}
