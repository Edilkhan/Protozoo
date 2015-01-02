package org.protozoo.system.event;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractEventSubscriber implements EventHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    final static String[] topics = new String[]{
        "org/woz/protozoa/system/event/WARNING",
        "org/woz/protozoa/system/event/ERROR",
        "org/woz/protozoa/system/event/PING"
    };

    public AbstractEventSubscriber() {
    }

    public Dictionary init(BundleContext context) {
        Dictionary d = new Hashtable<>();
        d.put(EventConstants.EVENT_TOPIC, topics);
        /*d.put(EventConstants.EVENT_FILTER,
                "(bundle.symbolicName=org.woz.protozoa.*)");*/
        return d;
    }

    /**
     * {@inheritDoc}
     *
     * @param event Event received an to be handled
     */
    @Override
    public void handleEvent(Event event) {
        logger.info("Handle event: " + event + ", " + Arrays.toString(event.getPropertyNames()));
    }

}
