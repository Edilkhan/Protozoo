/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import javax.jdo.PersistenceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wolfgang
 */
public class LocationResourceImpl implements LocationResource {

    protected final Logger log = LoggerFactory.getLogger(LocationResourceImpl.class);
    
    PersistenceManager pm;
    
    @Override
    public String getLocation(String name) {
        pm.getObjectById("Location", name);
        pm.get
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
