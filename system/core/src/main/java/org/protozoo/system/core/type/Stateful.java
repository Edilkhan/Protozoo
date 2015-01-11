/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.system.core.type;

/**
 *
 * @author wos
 */
public interface Stateful {
    
    public void setState(State s);
    public State getState();
    
}
