/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.driver;

import java.util.HashMap;
import java.util.UUID;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wolfgang
 */
public class PingerDriver extends AbstractDriver {

    private final Logger logger = LoggerFactory.getLogger(PingerDriver.class);
    
    static final String ID = UUID.randomUUID().toString();
    static final String CATEGORY = "pinger";

    static final String[] topics = new String[]{
        "org/protozoo/event/COMMAND",
        "org/protozoo/event/ERROR",
        "org/protozoo/event/PING"
    };
    
    public PingerDriver() {
        super(ID, CATEGORY);
        
        HashMap<String, Object> map = new HashMap<>();
        map.put(EventConstants.EVENT_TOPIC, topics);
        map.put(EventConstants.EVENT_FILTER, getFilter());
        
        
    }
    
    @Override
    public void handleEvent(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getFilter() {
        return "(&" 
                + "(bundle.symbolicName=org.protozoo.driver.*)"
                + ",(DRIVER_ID=" + getId() + ")"
                + ")";

    }

}
