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

    @Override
    public Location getLocation(String name) {
        return null;
    }

    @Override
    public List<Location> getLocations() {
        return null;
    }
    
    
}
