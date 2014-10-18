/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model.api;

import java.util.Set;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.core.type.Stateful;
import org.woz.protozoa.core.type.Typeful;

/**
 * Representing a device 
 * 
 * @author Wolfgang van Os
 * @since 0.0.1
 */
public interface IDevice extends Item, Stateful, Typeful {

    public void setLocation(ILocation location);
    public ILocation getLocation();

    public boolean addParameter(Parameter parameter);
    public boolean removeParameter(Parameter parameter);
    public Set<Parameter> getParameters();
}
