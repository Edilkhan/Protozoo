/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

/**
 *
 * @author wolfgang
 */
public interface LocationService {
    public Location getLocation(String name);
    public Location createLocation(String name);
    public Location updateLocation(Location location, String name, String description, State state, Type type);
}
