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
    
    public Location addLocation(Location newloc);
    public boolean removeLocation(String name);
    public Location getLocation(String name);
    public Collection<Item> getLocations();
    public int size();
    
}
