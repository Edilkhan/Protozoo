package org.woz.protozoa.io.cxf.rest.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) {
        System.out.println("Starting the REST bundle");
    }

    @Override
    public void stop(BundleContext context) {
        System.out.println("Stopping the REST bundle");
    }

}