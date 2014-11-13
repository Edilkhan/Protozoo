/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.woz.protozoa.model.mysql.Location;

/**
 *
 * @author wolfgang
 */
@Path("locations")
@Produces(MediaType.APPLICATION_JSON)
public interface LocationsResource {

    @GET
    public Collection<Location> getLocations();
    
    @GET
    @Path("{name}")
    public Location getLocation(@PathParam("name") String name) throws LocationNotFoundException;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Location addLocation();
}
