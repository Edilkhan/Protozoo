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
import org.protozoo.io.rest.exception.CreateDeviceFailedException;
import org.protozoo.io.rest.exception.DeleteDeviceFailedException;
import org.protozoo.io.rest.exception.DeviceNotFoundException;
import org.protozoo.io.rest.exception.UpdateDeviceFailedException;
import org.protozoo.model.mysql.Device;

/**
 *
 * @author wolfgang
 */
@Path("devices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DevicesResource {
    
    @GET
    public Response getDevices();
    
    @GET
    @Path("{uuid}")
    public Response getDevice(@PathParam("uuid") String uuid) throws DeviceNotFoundException;
 
    @GET
    @Path("{uuid}/parameters")
    public Response getParametersByDevice(@PathParam("uuid") String uuid) throws DeviceNotFoundException;
    
    @POST
    public Response createDevice(Device device) throws CreateDeviceFailedException;

    @PUT
    public Response updateDevice(Device device) throws UpdateDeviceFailedException;
    
    @DELETE
    @Path("uuid")
    public Response deleteDevice(@PathParam("uuid") String uuid) throws DeleteDeviceFailedException;
    
}

