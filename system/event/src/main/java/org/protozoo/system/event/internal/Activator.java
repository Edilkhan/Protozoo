/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.system.event.internal;

import org.apache.commons.lang.StringUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.protozoo.system.event.AbstractEventSubscriber;

/**
 *
 * @author wolfgang
 */
public class Activator implements BundleActivator {

    private final Logger logger = LoggerFactory.getLogger(Activator.class);

    @Override
    public void start(BundleContext context) throws Exception {
        String version = context.getBundle().getVersion().toString();
        // if the version string contains a qualifier, remove it!
        if (StringUtils.countMatches(version, ".") == 3) {
            version = StringUtils.substringBeforeLast(version, ".");
        }

        logger.info("Protozoa event runtime started (v{}).", version);
        
        AbstractEventSubscriber subscriber = new AbstractEventSubscriber();
        context.registerService(EventHandler.class.getName(),
                subscriber, subscriber.init(context));
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        logger.info("Protozoa event runtime stopped.");
    }
}
