/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model;

import java.util.HashSet;
import java.util.Set;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import static org.woz.protozoa.core.type.State.ACTIVE;
import org.woz.protozoa.core.type.Type;
import static org.woz.protozoa.core.type.Type.PHYSICAL;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;
import org.woz.protozoa.model.api.IParameter;

/**
 *
 * @author Wolfgang van Os
 */
public class GenericDevice extends AbstractItem implements IDevice {

    private String name;
    private String description;
    
    private State state;
    private Type type;

    private ILocation location;
    private final Set<IParameter> parameters = new HashSet<>();

    public GenericDevice(ILocation location, String name) {
        this(location, name, null);
    }

    /**
     * Creates a new IDevice, attached to the specified {@link ILocation} with the
     * given name and description
     *
     * @param location to which this device is attached
     * @param name is the identifier of the device
     * @param description of the new device
     */
    public GenericDevice(ILocation location, String name, String description) {
      
        this.name = name;
        this.description = description;
        this.location = location;
        this.state = ACTIVE;
        this.type = PHYSICAL;
        
    }

    @Override
    public void setLocation(ILocation location) {
        this.location = location;

        if (location != null) {
            location.addDevice(this);
        }
    }

    @Override
    public ILocation getLocation() {
        return this.location;
    }

    @Override
    public Set<IParameter> getParameters() {
        return this.parameters;
    }

    @Override
    public boolean addParameter(IParameter parameter) {
        return parameters.add(parameter);
    }

    @Override
    public boolean removeParameter(IParameter parameter) {
        return parameters.remove(parameter);
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

}
