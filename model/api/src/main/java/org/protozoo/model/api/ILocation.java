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
 * Either the physical or functional location, identified by a unique name. For
 * example, a physical location can be 'Office-22@UK' or a functional location
 * 'Fast movers'
 *
 * @author Wolfgang van Os
 * @since 1.0.0
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public interface ILocation extends Item, Stateful, Typeful {

    public String getName();
    public void setName(String name);

    public String getDescription();
    public void setDescription(String name);
    
    public boolean addDevice(IDevice device);
    public boolean removeDevice(IDevice device);
    public IDevice getDevice(String deviceName);
    public Set<?> getDevices();
    
}
