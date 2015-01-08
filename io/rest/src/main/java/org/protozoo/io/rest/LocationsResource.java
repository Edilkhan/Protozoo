/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.io.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.protozoo.io.rest.exception.CreateLocationFailedException;
import org.protozoo.io.rest.exception.DeleteLocationFailedException;
import org.protozoo.io.rest.exception.LocationNotFoundException;
import org.protozoo.io.rest.exception.UpdateLocationFailedException;
import org.protozoo.model.mysql.Location;

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
    
    @GET
    @Path("{name}/devices")
    public Response getDevicesByLocation(@PathParam("name") String name) throws LocationNotFoundException;

    @POST
    public Response createLocation(Location location) throws CreateLocationFailedException;
    
    @PUT
    public Response updateLocation(Location location) throws UpdateLocationFailedException;
    
    @DELETE
    public Response deleteLocation(@PathParam("name") String name) throws DeleteLocationFailedException;
    
}
