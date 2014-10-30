/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model;

import org.woz.protozoa.model.api.IMeasurement;
import org.woz.protozoa.core.item.Item;

/**
 *
 * @author Wolfgang van Os
 */
public interface Sensor extends Item {
    
    /**
     * Read the current value of the sensor
     * 
     * @return the current value of the sensor
     */
    public IMeasurement read(); 
}
