/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model.api;

import java.util.Set;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.core.type.Stateful;
import org.woz.protozoa.core.type.Typeful;

/**
 * Either the physical or functional location, identified by a unique name. For
 * example, a physical location can be 'Office-22@UK' or a functional location
 * 'Fast movers'
 *
 * @author Wolfgang van Os
 * @since 1.0.0
 */
public interface ILocation extends Item, Stateful, Typeful {

    public boolean addDevice(IDevice device);
    public boolean removeDevice(IDevice device);
    public IDevice getDevice(String deviceName);
    public Set<IDevice> getDevices();
    
}
