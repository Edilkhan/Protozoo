/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.protozoo.services.model.internal;

import org.apache.commons.lang.StringUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        logger.info("Protozoa model services started (v{}).", version);
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        logger.info("Protozoa model services stopped.");
    }
    
}
