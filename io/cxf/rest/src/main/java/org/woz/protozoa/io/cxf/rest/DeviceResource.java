/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.cxf.rest;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.model.api.IDevice;

/**
 *
 * @author wolfgang
 */
@Path("/devices")
public interface DeviceResource {
    
    @GET
    Collection<Item> getAllDevices();
    
    @GET
    @Path("{id}")
    IDevice getDevice(@PathParam("id") String id);
}
