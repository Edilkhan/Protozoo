/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wolfgang
 */
@Path("/locations/")
public interface LocationResource {
    @GET
    @Path("{name}")
    // @Produces("application/xml")
    public String getLocation(@PathParam("name") String name);
    
    @GET
    @Path("list")
    public String getLocations();
    
    @POST
    @Path("new")
    @Consumes("text/html")
    public ILocation addLocation(
        @QueryParam("name") String name,
        @QueryParam("description") String description
    );
}
