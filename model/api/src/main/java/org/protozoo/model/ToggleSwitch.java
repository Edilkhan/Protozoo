/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model;

/**
 * This class implements the behavior of a toggle switch. Its value it either ON
 * or OFF, therefore always has a defined state.
 *
 * @author Wolfgang van Os
 */
public abstract class ToggleSwitch implements Toggle, Switch {

    /**
     * Default value of the toggle switch is OFF
     */
    private boolean value = false;
    
    @Override
    public boolean toggle() {
        value = !value;
        
        return !value;
    }

}
