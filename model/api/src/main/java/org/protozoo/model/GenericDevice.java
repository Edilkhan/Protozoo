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
import org.protozoo.model.api.IParameter;

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
