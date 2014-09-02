/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.services.model.Location;

/**
 *
 * @author wolfgang
 */
public class LocationServiceImpl implements LocationService {
    protected final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    private org.woz.protozoa.services.model.LocationService ls;
    
    @Override
    public Location getLocation(String name) {
        if (ls == null) {
            System.out.println("Service has not been set");
            return null;
        }
        return ls.getLocation(name);
    }

    @Override
    public List<Location> getLocations() {
        return null;
    }    
}
