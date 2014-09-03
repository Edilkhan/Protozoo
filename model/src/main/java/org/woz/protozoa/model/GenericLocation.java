/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model;

import java.util.HashSet;
import java.util.Set;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.spi.Device;
import org.woz.protozoa.model.spi.Location;

/**
 * 
 * 
 * @author Wolfgang van Os
 * @since 0.0.1
 */
public class GenericLocation extends AbstractItem implements Location {
  
    private final Set<Device> devices = new HashSet<>();

    public GenericLocation(String name) {
        this(name, null);
    }
    
    public GenericLocation(String name, String description) {
        super(name, description);
    }
    
    @Override
    public boolean addDevice(Device device) {
        return devices.add(device);
    }
    
    @Override
    public boolean removeDevice(Device device) {
        return devices.remove(device);
    }
    
    public int numberOfDevices() {
        return devices.size();
    }

    @Override
    public Set<Device> getDevices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setType(Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Device getDevice(String deviceName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
