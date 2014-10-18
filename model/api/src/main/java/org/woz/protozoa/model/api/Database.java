/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.api;

import java.util.Collection;
import org.woz.protozoa.core.item.Item;

/**
 *
 * @author wolfgang
 */
public interface Database {
    
    public int size();

    public ILocation addLocation(ILocation newloc);
    public boolean removeLocation(String name);
    public ILocation getLocation(String name);
    public Collection<Item> getLocations();
    
    public IDevice addDevice(IDevice newdev);
    public boolean removeDevice(String name);
    public IDevice getDevice(String name);
    public Collection<Item> getDevices();
    
}