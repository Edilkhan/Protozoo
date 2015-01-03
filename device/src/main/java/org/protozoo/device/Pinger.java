/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.device;

import org.osgi.framework.BundleContext;
import org.osgi.service.device.Device;
import org.protozoo.core.type.Stateful;

/**
 *
 * @author wolfgang
 */
public interface Pinger extends Device, Stateful {

    public void register(BundleContext bc);
    public void unregister();
}
