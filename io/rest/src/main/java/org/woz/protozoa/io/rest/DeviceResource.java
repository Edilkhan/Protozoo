/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author wolfgang
 */
@Path("/devices")
public interface DeviceResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllDevices();
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String getDevice(@PathParam("id") String id);
}
