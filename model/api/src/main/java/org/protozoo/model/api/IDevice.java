/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model.api;

import java.util.Set;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import org.protozoo.core.item.Item;
import org.protozoo.core.type.Stateful;
import org.protozoo.core.type.Typeful;

/**
 * Representing a device 
 * 
 * @author Wolfgang van Os
 * @since 0.0.1
 */
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
