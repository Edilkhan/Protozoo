/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model;

import java.util.HashSet;
import java.util.Set;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;

/**
 * 
 * 
 * @author Wolfgang van Os
 * @since 0.0.1
 */
public class GenericLocation extends AbstractItem implements ILocation {
  
    private final Set<IDevice> devices = new HashSet<>();
    private State state;
    private Type type;

    protected GenericLocation() {
        
    }
    
    public GenericLocation(String name) {
        this(name, null);
    }
    
    public GenericLocation(String name, String description) {
        super(name, description);
    }
    
    @Override
    public boolean addDevice(IDevice device) {
        return devices.add(device);
    }
    
    @Override
    public boolean removeDevice(IDevice device) {
        return devices.remove(device);
    }
    
    public int numberOfDevices() {
        return devices.size();
    }

    @Override
    public Set<IDevice> getDevices() {
        return this.devices;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public IDevice getDevice(String deviceName) {
        for (IDevice d : devices) {
            if (d.getName().equals(deviceName)) {
                return d;
            }
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        return "{ " + getName() + ", " + getDescription() + ", " + getState() + ", " + getType() + " }";
    }
}
