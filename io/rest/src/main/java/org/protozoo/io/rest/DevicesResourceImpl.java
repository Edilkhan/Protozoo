/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.io.rest;

import java.util.Collection;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.protozoo.io.rest.exception.CreateDeviceFailedException;
import org.protozoo.io.rest.exception.DeleteDeviceFailedException;
import org.protozoo.io.rest.exception.DeviceNotFoundException;
import org.protozoo.io.rest.exception.UpdateDeviceFailedException;
import org.protozoo.model.mysql.Device;
import org.protozoo.model.mysql.Location;
import org.protozoo.model.mysql.MySQLRepository;

/**
 *
 * @author wolfgang
 */
public class DevicesResourceImpl implements DevicesResource {
    
    protected final Logger log = LoggerFactory.getLogger(DevicesResourceImpl.class);

    static MySQLRepository repo = new MySQLRepository();
      
    @Override
    public Response getDevices() {
    
        Collection<Device> result = (Collection<Device>) repo.getItems(Device.class);
        /* repo.getItemsByQuery(Device.class, "location.id == \"" + location.getId() + "\""); */
        
        GenericEntity<Collection<Device>> entity = new GenericEntity<Collection<Device>>(result) {};
        
        Response rep = Response.status(Response.Status.OK)
                .entity(entity)
                .type(MediaType.APPLICATION_JSON)
                .build();
        
        return rep;
    }

    @Override
    public Response getDevice(String uuid) throws DeviceNotFoundException {

        log.info("Get device with uuid: " + uuid);
        
        Device device = (Device) repo.getItemByName(Device.class, uuid);
        if (device == null) {
            throw new DeviceNotFoundException("Device with uuid not found");
        }
        
        return Response.status(Response.Status.OK)
                .entity(device)
                .build();
    }

    @Override
    public Response getParametersByDevice(String uuid) throws DeviceNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response createDevice(Device device) throws CreateDeviceFailedException {
        log.info("Create device " + device);

        Device newDevice = (Device) repo.createItem(device);
        
        if (newDevice != null) {
        
        return Response.status(Response.Status.CREATED)
                .entity(newDevice)
                .build();
        } else {
            throw new CreateDeviceFailedException();
        }
    }

    @Override
    public Response updateDevice(Device device) throws UpdateDeviceFailedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response deleteDevice(String name) throws DeleteDeviceFailedException {
        
        log.info("Delete device");
        
        Device device = (Device) repo.getItemByName(Device.class, name);
        
        if (device != null && repo.deleteItem(device)) {        

            return Response.status(Response.Status.NO_CONTENT)
                    .header("X-RateLimit-Limit", 5000)
                    .header("X-RateLimit-Remaining", 4999)
                    .build();
        } else {
            throw new DeleteDeviceFailedException();
        }
    }
}
