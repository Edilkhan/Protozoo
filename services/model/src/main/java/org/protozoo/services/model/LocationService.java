/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.protozoo.services.model;

import org.protozoo.core.type.State;
import org.protozoo.core.type.Type;
import org.protozoo.model.api.ILocation;

/**
 *
 * @author wolfgang
 */
public interface LocationService {
    public ILocation createLocation(String name);
    public ILocation getLocation(String name);
    public ILocation updateLocation(String name, String description, State state, Type type);
    public boolean removeLocation(String name);
}
