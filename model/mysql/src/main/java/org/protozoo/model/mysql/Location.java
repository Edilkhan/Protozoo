/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.model.mysql;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Unique;
import javax.xml.bind.annotation.XmlRootElement;
import org.protozoo.system.core.item.AbstractItem;
import org.protozoo.system.core.type.State;
import static org.protozoo.system.core.type.State.ACTIVE;
import org.protozoo.system.core.type.Type;
import static org.protozoo.system.core.type.Type.PHYSICAL;

/**
 *
 * @author wos
 */
@XmlRootElement
@PersistenceCapable(table = "Location")
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public class Location extends AbstractItem {

    @Unique
    private String name;
    private String description;
    
    private State state;
    private Type type;

    @Join
    private final Set<Device> devices = new HashSet<>();
    
    private Location() {
        
    }
    
    public Location(String name) {
        this(name, null);
    }
    
    public Location(String name, String description) {
      
        this.name = name;
        this.description = description;
        this.state = ACTIVE;
        this.type = PHYSICAL;

    }
    
    public boolean addDevice(Device device) {
        return devices.add((Device)device);
    }
    
    public boolean removeDevice(Device device) {
        return devices.remove((Device)device);
    }
    
    public int numberOfDevices() {
        return devices.size();
    }

    
    public Set<Device> getDevices() {
        return this.devices;
    }

    public void setState(State state) {
        this.state = state;
    }

    
    public State getState() {
        return this.state;
    }

    
    public void setType(Type type) {
        this.type = type;
    }

    
    public Type getType() {
        return this.type;
    }

    
    public Device getDevice(String deviceName) {
        for (Device d : devices) {
            if (d.getName().equals(deviceName)) {
                return d;
            }
        }
        
        return null;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    @Override
    public String toString() {
        return "{ " + getName() + ", " + getDescription() + ", " + getState() + ", " + getType() + " }";
    }
}
