/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device;

/**
 *
 * @author wolfgang
 */
public interface Pinger extends IDevice {
    
    public void setFrequency(float frequency);
    public float getFrequency();

}
