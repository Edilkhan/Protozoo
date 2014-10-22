/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import static org.woz.protozoa.core.type.State.ACTIVE;
import org.woz.protozoa.core.type.Type;
import static org.woz.protozoa.core.type.Type.PHYSICAL;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wos
 */
@PersistenceCapable(table = "Location")
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public class Location extends AbstractItem implements ILocation {

    private String name;
    private String description;
    
    private State state;
    private Type type;

    @Join
    private final Set<Device> devices = new HashSet<>();
    
    public Location(String name) {
        this(name, null);
    }
    
    public Location(String name, String description) {

        super(name);
        
        this.name = name;
        this.description = description;
        this.state = ACTIVE;
        this.type = PHYSICAL;

    }
    
    @Override
    public boolean addDevice(IDevice device) {
        return devices.add((Device)device);
    }
    
    @Override
    public boolean removeDevice(IDevice device) {
        return devices.remove((Device)device);
    }
    
    public int numberOfDevices() {
        return devices.size();
    }

    @Override
    public Set<Device> getDevices() {
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
    public String toString() {
        return "{ " + getName() + ", " + getDescription() + ", " + getState() + ", " + getType() + " }";
    }
}
