/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.woz.protozoa.services.model.Location;

/**
 *
 * @author wolfgang
 */
@Path("/location/")
public interface LocationService {
    @GET
    @Path("{name}")
    @Produces({"application/xml","application/json"})
    public Location getLocation(@PathParam("name") String name);
    
    @GET
    @Path("All")
    @Produces({"application/xml","application/json"})
    public List<Location> getLocations();
}
