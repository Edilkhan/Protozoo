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
import javax.jdo.annotations.PersistenceCapable;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import static org.woz.protozoa.core.type.State.ACTIVE;
import org.woz.protozoa.core.type.Type;
import static org.woz.protozoa.core.type.Type.PHYSICAL;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;
import org.woz.protozoa.model.api.Parameter;

/**
 *
 * @author wos
 */
@PersistenceCapable(table = "Device")
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public class Device extends AbstractItem implements IDevice{

    private String name;
    private String description;
    
    private State state;
    private Type type;

    private Location location;
    private final Set<Parameter> parameters = new HashSet<>();

    public Device(String name) {
        this(name, null);
    }

    /**
     * Creates a new Device, attached to the specified {@link ILocation} with the
     * given name and description
     *
     * @param name is the identifier of the device
     * @param description of the new device
     */
    public Device(String name, String description) {
        super(name);
        
        this.name = name;
        this.description = description;
        this.state = ACTIVE;
        this.type = PHYSICAL;

    }

    @Override
    public void setLocation(ILocation location) {
        this.location = (Location)location;
    }

    @Override
    public ILocation getLocation() {
        return this.location;
    }

    @Override
    public Set<Parameter> getParameters() {
        return this.parameters;
    }

    @Override
    public boolean addParameter(Parameter parameter) {
        return parameters.add(parameter);
    }

    @Override
    public boolean removeParameter(Parameter parameter) {
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

    @Override
    public String toString() {
        return "{ " + getName() + ", " + getDescription() + ", " + getState() + ", " + getType() + " }";
    }    
}
