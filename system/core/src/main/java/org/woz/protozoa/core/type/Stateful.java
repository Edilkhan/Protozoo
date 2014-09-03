/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.type;

/**
 *
 * @author wos
 */
public interface Stateful {
    
    public void setState(State state);
    public State getState();
    
}
