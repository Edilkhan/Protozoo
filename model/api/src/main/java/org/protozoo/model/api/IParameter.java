/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model.api;

import java.util.Set;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import org.protozoo.system.core.item.Item;
import org.protozoo.system.core.type.Stateful;
import org.protozoo.system.core.type.Typeful;

/**
 *
 * @author Wolfgang van Os
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public interface IParameter extends Item, Stateful, Typeful {
    
    public void setDevice(IDevice device);
    public IDevice getDevice();
    
    public boolean addMeasurement(IMeasurement measurement);
    public boolean removeMeasurement(IMeasurement measurement);
    // public Measurement getMeasurement();
    public Set<IMeasurement> getMeasurements();
}
