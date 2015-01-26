/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.protozoo.device.internal;

import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import org.apache.commons.lang.StringUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.protozoo.device.Pinger;
import org.protozoo.device.impl.PingerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {

    private final Logger logger = LoggerFactory.getLogger(Activator.class);

    private Pinger p;
    
    ConfigurationAdmin ca;

    @Override
    public void start(BundleContext context) {
        
        String version = context.getBundle().getVersion().toString();
        // if the version string contains a qualifier, remove it!
        if (StringUtils.countMatches(version, ".") == 3) {
            version = StringUtils.substringBeforeLast(version, ".");
        }

        //registerDevices(context);
        PingerFactory pf = new PingerFactory();
        pf.register(context);

        ca = context.getService(context.getServiceReference(ConfigurationAdmin.class));
        if (ca != null) {
            try {
                Configuration c = ca.createFactoryConfiguration(Pinger.class.getName());
                Hashtable props = new Hashtable();
                props.put("Frequency", 2.0f);
                c.update(props);
                System.out.println("Properties: " + c.getProperties());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Activator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("CA = null");
        }
        
        logger.info("Protozoo device runtime started (v{}).", version);

    }

    @Override
    public void stop(BundleContext context) {

        unregisterDevices();
        
        logger.info("Protozoo device runtime stopped.");

    }

    private void registerDevices(BundleContext context) {
        p = new PingerImpl();
        p.register(context);        
    }

    private void unregisterDevices() {
        p.unregister();
    }
    
}
