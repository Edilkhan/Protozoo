/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.woz.protozoa.model.api.IDevice;

/**
 *
 * @author wolfgang
 */
@Path("/devices/")
public interface DeviceResource {
    
    @GET
    @Path("list")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDevices();
    
    @GET
    @Path("{id}")
    @NotNull(message = "{device.does.not.exist")
    @Produces(MediaType.APPLICATION_JSON)
    public IDevice getDevice(@PathParam("id") String id);
}
