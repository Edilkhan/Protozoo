/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wolfgang
 */
public class LocationServiceImpl implements LocationService {
    protected final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    
    private org.woz.protozoa.services.model.LocationService ls = null;
    
    @Override
    public String getLocation(String name) {
        return ls.getLocation(name).toString();
    }

    @Override
    public String getLocations() {
        return "Not implemented yet";
    }

    public org.woz.protozoa.services.model.LocationService getLs() {
        return ls;
    }

    public void setLs(org.woz.protozoa.services.model.LocationService ls) {
        this.ls = ls;
    }
}
