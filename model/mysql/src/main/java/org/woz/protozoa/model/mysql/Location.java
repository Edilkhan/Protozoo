/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wos
 */
@PersistenceCapable(table = "Location")
public class Location extends AbstractItem implements ILocation {

    @Join private final Set<IDevice> devices = new HashSet<>();
    private State state;
    private Type type;

    public Location(String name) {
        this(name, null);
    }
    
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
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
