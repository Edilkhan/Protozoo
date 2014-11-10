/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.woz.protozoa.model.mysql.Device;

/**
 *
 * @author wolfgang
 */
@Path("devices")
@Produces(MediaType.APPLICATION_JSON)
public interface DevicesResource {
    
    @GET
    public Collection<Device> getDevices();
    
    @GET
    @Path("{name}")
    public Device getDevice(@PathParam("name") String name);
}

