/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model;

/**
 * Main interface for all toggles
 * 
 * @author Wolfgang van Os
 */
public interface Toggle {

    /**
     * Toggle the current value from ON to OFF and vice versa
     * 
     * @return previous value of the toggle
     */
    public boolean toggle();
}
