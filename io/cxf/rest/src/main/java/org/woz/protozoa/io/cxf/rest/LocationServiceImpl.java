/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import java.util.List;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.services.model.HashDB;
import org.woz.protozoa.services.model.Location;

/**
 *
 * @author wolfgang
 */
@Component
@Instantiate
public class LocationServiceImpl implements LocationService {
    protected final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    @Requires
    protected HashDB database;
    
    @Override
    public Location getLocation(String name) {
        return database.getLocation(name);
    }

    @Override
    public List<Location> getLocations() {
        return null;
    }
    
    
}
