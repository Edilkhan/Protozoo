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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.protozoo.io.rest.exception.CreateDeviceFailedException;
import org.protozoo.io.rest.exception.DeleteDeviceFailedException;
import org.protozoo.io.rest.exception.DeviceNotFoundException;
import org.protozoo.model.mysql.Device;
import org.protozoo.model.mysql.Location;

/**
 *
 * @author wolfgang
 */
//@Path("devices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DevicesResource {
    
    @GET
    public Response getDevices(Location location);
    
    @GET
    @Path("{name}")
    public Response getDevice(@PathParam("name") String name) throws DeviceNotFoundException;
    
    @POST
    public Response createDevice(Device device) throws CreateDeviceFailedException;
    
    @DELETE
    public Response deleteDevice(@PathParam("name") String name) throws DeleteDeviceFailedException;
    
}

