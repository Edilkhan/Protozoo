package org.protozoo.core.internal;

import org.apache.commons.lang.StringUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.protozoo.device.PingerDriver;
import org.protozoo.device.PingerImpl;

public class Activator implements BundleActivator {

    private final Logger logger = LoggerFactory.getLogger(Activator.class);
    private final PingerImpl pingerDevice = new PingerImpl();
    private final PingerDriver pingerDriver = new PingerDriver();

    @Override
    public void start(BundleContext context) throws Exception {
        String version = context.getBundle().getVersion().toString();
        // if the version string contains a qualifier, remove it!
        if (StringUtils.countMatches(version, ".") == 3) {
            version = StringUtils.substringBeforeLast(version, ".");
        }

        pingerDevice.register(context);
        pingerDriver.register(context);
        
        logger.info("Protozoa core runtime started (v{}).", version);
        logger.info(context.getBundle().getHeaders().toString());

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        pingerDriver.unregister();
        pingerDevice.unregister();
        
        logger.info("Protozoa core runtime stopped.");
    }
}
