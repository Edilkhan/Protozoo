/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model.api;

import java.util.Set;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.core.type.Stateful;
import org.woz.protozoa.core.type.Typeful;

/**
 *
 * @author Wolfgang van Os
 */
public interface Parameter extends Item, Stateful, Typeful {
    
    public void setDevice(Device device);
    public Device getDevice();
    
    public boolean addMeasurement(Measurement measurement);
    public boolean removeMeasurement(Measurement measurement);
    // public Measurement getMeasurement();
    public Set<Measurement> getMeasurements();
}
