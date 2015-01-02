package org.protozoo.system.event;

import org.osgi.service.event.EventAdmin;

public class EventPublisherImpl implements EventPublisher {

    private EventAdmin eventAdmin;

    public void setEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }

    public void unsetEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin = null;
    }

}
