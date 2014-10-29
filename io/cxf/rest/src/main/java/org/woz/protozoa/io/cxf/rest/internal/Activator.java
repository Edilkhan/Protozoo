package org.woz.protozoa.io.cxf.rest.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private static final String bundleTitle = "Protozoa REST";
    
    @Override
    public void start(BundleContext context) {
        System.out.println("Starting: " + bundleTitle);
    }

    @Override
    public void stop(BundleContext context) {
        System.out.println("Stopping: " + bundleTitle);
    }

}