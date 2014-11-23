/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.rest;

import org.woz.protozoa.io.rest.exception.LocationNotFoundException;
import java.util.Collection;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.io.rest.exception.CreateLocationFailedException;
import org.woz.protozoa.io.rest.exception.DeleteLocationFailedException;
import org.woz.protozoa.model.mysql.Location;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
public class LocationsResourceImpl implements LocationsResource {

    protected final Logger log = LoggerFactory.getLogger(LocationsResourceImpl.class);
    
    static MySQLRepository repo = new MySQLRepository();
    
    @Override
    public Response getLocations() {
    
        Collection<Location> result = (Collection<Location>) repo.getItems(Location.class);
        
        GenericEntity<Collection<Location>> entity = new GenericEntity<Collection<Location>>(result) {};
        
        Response rep = Response.status(Response.Status.OK)
                .entity(entity)
                .type(MediaType.APPLICATION_JSON)
                .build();
        
        return rep;
    }

    @Override
    public Response getLocation(String name) throws LocationNotFoundException {
        log.info("Get location with name: " + name);
        
        Location loc = (Location) repo.getItemByName(Location.class, name);
        if (loc == null) {
            throw new LocationNotFoundException("Location with name not found");
        }
        
        return Response.status(Response.Status.OK)
                .entity(loc)
                .build();
    }

    @Override
    public Response createLocation(Location loc) throws CreateLocationFailedException {
        log.info("Create location " + loc);

        Location newLocation = (Location) repo.createItem(loc);
        
        if (newLocation != null) {
        
        return Response.status(Response.Status.CREATED)
                .entity(newLocation)
                .build();
        } else {
            throw new CreateLocationFailedException();
        }
    }

    @Override
    public Response deleteLocation(String name) throws DeleteLocationFailedException {
        
        log.info("Delete location ");
        
        Location loc = (Location) repo.getItemByName(Location.class, name);
        
        if (loc != null && repo.deleteItem(loc)) {        

            return Response.status(Response.Status.NO_CONTENT)
                    .header("X-RateLimit-Limit", 5000)
                    .header("X-RateLimit-Remaining", 4999)
                    .build();
        } else {
            throw new DeleteLocationFailedException();
        }
    }
}
