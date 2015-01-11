/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.system.core.type;

/**
 *
 * @author wolfgang
 */
public enum Capability {

    // Generic capabilities, like switching on or off an item
    
    ON,
    OFF,
    TOGGLE,
    STANDBY,
    PING,
    
    // Specific capabilities for consumer electronics, like TV sets and tuners
    
    VOLUME_UP,
    VOLUME_DOWN,
    CHANNEL_UP,
    CHANNEL_DOWN,
    TRACK_NEXT,
    TRACK_PREVIOUS

    
}
