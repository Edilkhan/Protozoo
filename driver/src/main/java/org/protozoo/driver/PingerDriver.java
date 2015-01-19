/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.driver;

import java.util.HashMap;
import java.util.UUID;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
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
    public String attach(ServiceReference reference) throws Exception {

        logger.info("Create pinger tracker: " + reference.toString());
        new PingerTracker(getContext(), reference);

        return null;
    }


    @Override
    public void handleEvent(Event event) {
        System.out.println("Driver handled event: " + event.toString());
    }

    @Override
    public String getFilter() {
        return "(&"
        + "(objectclass=" + org.osgi.service.device.Driver.class.getName() + ")"
        + "(DEVICE_CATEGORY=" + CATEGORY + ")"
        + ")";
    }

}
