/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.model.mysql;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
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
@PersistenceCapable(table = "Device")
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public class Device extends AbstractItem {

    private String name;
    private String description;
    
    private State state;
    private Type type;

    private Location location;
//    private final Set<IParameter> parameters = new HashSet<>();

    private Device() {
        
    }
    
    public Device(String name) {
        this(name, null);
    }

    /**
     * Creates a new Device, attached to the specified {@link Location} with the
     * given name and description
     *
     * @param name is the identifier of the device
     * @param description of the new device
     */
    public Device(String name, String description) {
        
        this.name = name;
        this.description = description;
        this.state = ACTIVE;
        this.type = PHYSICAL;

    }

    
    public void setLocation(Location location) {
        this.location = (Location)location;
    }

    
    public Location getLocation() {
        return this.location;
    }

/*    
    public Set<IParameter> getParameters() {
        return this.parameters;
    }

    
    public boolean addParameter(IParameter parameter) {
        return parameters.add(parameter);
    }

    
    public boolean removeParameter(IParameter parameter) {
        return parameters.remove(parameter);
    }
*/
    
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

    @Override
    public String toString() {
        return "{ " + getName() + ", " + getDescription() + ", " + getState() + ", " + getType() + " }";
    }    
}
