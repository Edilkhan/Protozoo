/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.woz.protozoa.io.rest.exception.CreateLocationFailedException;
import org.woz.protozoa.io.rest.exception.DeleteLocationFailedException;
import org.woz.protozoa.io.rest.exception.LocationNotFoundException;
import org.woz.protozoa.model.mysql.Location;

/**
 * CRUD operations on Locations
 * 
 * @since 1.0
 * @author Wolfgang van Os
 */

@Path("locations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface LocationsResource {

    @GET
    public Response getLocations();
    
    @GET
    @Path("{name}")
    public Response getLocation(@PathParam("name") String name) throws LocationNotFoundException;
    
    @POST
    public Response createLocation(Location location) throws CreateLocationFailedException;
    
    @DELETE
    public Response deleteLocation(@PathParam("name") String name) throws DeleteLocationFailedException;
    
}
