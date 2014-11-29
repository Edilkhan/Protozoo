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

    /*
     * Generic CRUD operations
     */
    
    public Item createItem(Item item);
    public Item getItemByName(Class clazz, String name);
    public Collection<?> getItems(Class clazz);
    public Collection<?> getItemsByQuery(Class clazz, String query);
    
    public Item updateItem(Item item);
    public boolean deleteItem(Item item);
    public boolean deleteItemByName(Class clazz, String name);
}
