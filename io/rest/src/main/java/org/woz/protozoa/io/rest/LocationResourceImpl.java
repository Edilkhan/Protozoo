/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.rest;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.model.api.ILocation;
import org.woz.protozoa.model.api.Repository;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
public class LocationResourceImpl implements LocationResource {

    protected final Logger log = LoggerFactory.getLogger(LocationResourceImpl.class);
    
    static Repository repo = new MySQLRepository();
    
    @Override
    public String getLocation(String name) {
        log.info("REST getLocation called...");
        
        ILocation loc = repo.getLocation(name);
        
        return loc.toString();
    }

    @Override
    public String getLocations() {
        Collection result = repo.getLocations();
        
        return result.toString();
    }

    @Override
    public ILocation addLocation(String name, String description) {
        log.info("Create location " + name);
        
        return repo.addLocation(name, description);
    }
}
