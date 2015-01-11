/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model;

import java.util.HashSet;
import java.util.Set;
import org.protozoo.system.core.item.AbstractItem;
import org.protozoo.system.core.type.State;
import static org.protozoo.system.core.type.State.ACTIVE;
import org.protozoo.system.core.type.Type;
import static org.protozoo.system.core.type.Type.PHYSICAL;
import org.protozoo.model.api.IDevice;
import org.protozoo.model.api.ILocation;

/**
 * 
 * 
 * @author Wolfgang van Os
 * @since 0.0.1
 */
public class GenericLocation extends AbstractItem implements ILocation {
  
    private String name;
    private String description;
    
    private State state;
    private Type type;

    private final Set<IDevice> devices = new HashSet<>();

    protected GenericLocation() {
        
    }
    
    public GenericLocation(String name) {
        this(name, null);
    }
    
    public GenericLocation(String name, String description) {
        
        this.name = name;
        this.description = description;
        this.state = ACTIVE;
        this.type = PHYSICAL;

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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
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
        return "{ " + getName() + ", " + getDescription() + " }";
    }

    @Override
    public void setState(State s) {
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
}
