/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.rest;

import org.woz.protozoa.io.rest.exception.LocationNotFoundException;
import java.util.Collection;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.io.rest.exception.CreateLocationFailedException;
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
    
        Collection result = repo.getLocations();
        
        return Response.status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @Override
    public Response getLocation(String name) throws LocationNotFoundException {
        log.info("Get location with name: " + name);
        
        Location loc = (Location) repo.getLocation(name);
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

        Location newLocation = repo.addLocation(loc.getName(), loc.getDescription());
        
        if (newLocation != null) {
        
        return Response.status(Response.Status.CREATED)
                .entity(newLocation)
                .build();
        } else {
            throw new CreateLocationFailedException();
        }
    }

    @Override
    public Response deleteLocation(Location loc) {
        log.info("Delete location ");
        
        repo.removeDevice(loc.getName());
        
        return Response.status(Response.Status.NO_CONTENT)
                .header("X-RateLimit-Limit", 5000)
                .header("X-RateLimit-Remaining", 4999)
                .build();
    }
}
