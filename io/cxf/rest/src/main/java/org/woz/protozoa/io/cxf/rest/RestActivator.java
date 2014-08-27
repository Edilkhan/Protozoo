package org.woz.protozoa.io.cxf.rest;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class RestActivator implements BundleActivator {

    @Override
    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
    }

    @Override
    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}