/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model;

import org.protozoo.model.api.IMeasurement;
import org.protozoo.core.item.Item;

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
