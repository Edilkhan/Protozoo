/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model.api;

/**
 *
 * @author wolfgang
 */
public interface Factory {
    
    public Database getDatabase();
    public ILocation createLocation(String name);
    public ILocation createLocation(String name, String description);

}
