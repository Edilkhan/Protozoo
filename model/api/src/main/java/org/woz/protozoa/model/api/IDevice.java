/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model.api;

import java.util.Set;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.xml.bind.annotation.XmlRootElement;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.core.type.Stateful;
import org.woz.protozoa.core.type.Typeful;

/**
 * Representing a device 
 * 
 * @author Wolfgang van Os
 * @since 0.0.1
 */
@XmlRootElement
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public interface IDevice extends Item, Stateful, Typeful {

    public String getName();
    public void setName(String name);
    public String getDescription();
    public void setDescription(String name);
    
    public void setLocation(ILocation location);
    public ILocation getLocation();

    public boolean addParameter(IParameter parameter);
    public boolean removeParameter(IParameter parameter);
    public Set<IParameter> getParameters();
}
