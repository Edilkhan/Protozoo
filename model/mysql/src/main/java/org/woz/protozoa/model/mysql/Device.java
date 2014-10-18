/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import org.woz.protozoa.core.type.State;
import static org.woz.protozoa.core.type.State.ACTIVE;
import org.woz.protozoa.core.type.Type;
import static org.woz.protozoa.core.type.Type.PHYSICAL;
import org.woz.protozoa.model.api.ILocation;
import org.woz.protozoa.model.api.Parameter;

/**
 *
 * @author wos
 */
@PersistenceCapable(table = "Device")
public class Device {

    String name;
    String description;
    private State state;
    private Type type;

    private ILocation location;
    private final Set<Parameter> parameters = new HashSet<>();

    public Device(ILocation location, String name) {
        this(location, name, null);
    }

    /**
     * Creates a new Device, attached to the specified {@link ILocation} with the
     * given name and description
     *
     * @param location to which this device is attached
     * @param name is the identifier of the device
     * @param description of the new device
     */
    public Device(ILocation location, String name, String description) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.state = ACTIVE;
        this.type = PHYSICAL;
    }

    public void setLocation(ILocation location) {
        this.location = location;

        if (location != null) {
            location.addDevice(this);
        }
    }

    public ILocation getLocation() {
        return this.location;
    }

    public Set<Parameter> getParameters() {
        return this.parameters;
    }

    public boolean addParameter(Parameter parameter) {
        return parameters.add(parameter);
    }

    public boolean removeParameter(Parameter parameter) {
        return parameters.remove(parameter);
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
}
