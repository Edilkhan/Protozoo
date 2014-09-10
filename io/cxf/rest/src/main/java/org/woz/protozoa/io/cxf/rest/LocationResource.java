/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author wolfgang
 */
@Path("/location/")
public interface LocationResource {
    @GET
    @Path("{name}")
    // @Produces("application/xml")
    public String getLocation(@PathParam("name") String name);
    
    @GET
    @Path("All")
    // @Produces({"application/xml","application/json"})
    public String getLocations();
}
