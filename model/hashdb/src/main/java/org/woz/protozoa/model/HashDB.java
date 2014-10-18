/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import java.util.Collection;
import java.util.HashMap;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.model.api.Database;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wos
 */
public class HashDB extends HashMap<String, Item> implements Database {
                   
    @Override
    public ILocation getLocation(String name) {
        
        return (ILocation)get(name);
    }

    @Override
    public ILocation addLocation(ILocation newloc) {

        if (newloc != null) {
            if (newloc.getName() != null && !newloc.getName().isEmpty()) {
                return (ILocation)put(newloc.getName(), newloc);
            } else {
                throw new IllegalArgumentException("Add location with empty name or null");
            }
        } else {
            throw new IllegalArgumentException("Add location with null parameter");
        }
    }

    @Override
    public boolean removeLocation(String name) {
        
        return (remove(name) != null);
        
    }

    @Override
    public Collection<Item> getLocations() {
        
        return (Collection<Item>)this.values();
        
    }
    
    @Override
    public IDevice getDevice(String name) {
        
        return (IDevice)get(name);
    }

    @Override
    public IDevice addDevice(IDevice newdev) {

        if (newdev != null) {
            if (newdev.getName() != null && !newdev.getName().isEmpty()) {
                return (IDevice)put(newdev.getName(), newdev);
            } else {
                throw new IllegalArgumentException("Add device with empty name or null");
            }
        } else {
            throw new IllegalArgumentException("Add device with null parameter");
        }
    }

    @Override
    public boolean removeDevice(String name) {
        
        return (remove(name) != null);
        
    }

    @Override
    public Collection<Item> getDevices() {
        
        return (Collection<Item>)this.values();
        
    }
    
}
