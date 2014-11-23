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
public interface IRepository {
    
    public ILocation addLocation(String name, String description);
    public boolean removeLocation(String name);
    public ILocation getLocation(String name);
    public Collection<?> getLocations();
    
    public IDevice addDevice(String name, String description);
    public boolean removeDevice(String name);
    public IDevice getDevice(String name);
    public Collection<?> getDevices();

    /*
     * Generic CRUD operations
     */
    
    public Item createItem(Item item);
    public Item getItemByName(String name);
    public Collection<?> getItems(Class clazz);
    public Item updateItem(Item item);
    public Item deleteItem(Item item);
    public Item deleteItemByName(String name);
}
