package org.protozoo.system.timer;

import java.util.Calendar;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator extends Thread implements BundleActivator {

    private final HashMap<String, Object> time = new HashMap<>();
    private ServiceTracker tracker;

    private final Logger logger = LoggerFactory.getLogger(Activator.class);

    public Activator() {
        super("Timer");
    }

    @Override
    public void start(BundleContext context) throws Exception {
        String version = context.getBundle().getVersion().toString();
        // if the version string contains a qualifier, remove it!
        if (StringUtils.countMatches(version, ".") == 3) {
            version = StringUtils.substringBeforeLast(version, ".");
        }

        tracker = new ServiceTracker(context, EventAdmin.class.getName(), null);
        tracker.open();
        start();

        logger.info("Protozoa timer runtime started (v{}).", version);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        interrupt();
        tracker.close();

        logger.info("Protozoa event runtime stopped.");
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Calendar c = Calendar.getInstance();
                set(c, Calendar.MINUTE, "minutes");
                set(c, Calendar.HOUR, "hours");
                set(c, Calendar.DAY_OF_MONTH, "day");
                set(c, Calendar.MONTH, "month");
                set(c, Calendar.YEAR, "year");
                EventAdmin ea
                        = (EventAdmin) tracker.getService();
                if (ea != null) {
                    Event event = new Event("org/woz/protozoa/system/event/PING", time);
                    ea.sendEvent(event);

                    logger.info("Event sent: " + event);
                } else {
                    logger.info("No EventAdmin registered");
                }

                Thread.sleep(60000 - c.get(Calendar.SECOND) * 1000);

            } catch (InterruptedException e) {
                return;
            }
        }
    }

    void set(Calendar c, int field, String key) {
        time.put(key, new String());
        time.put(key, new Integer(c.get(field)));
    }
}
