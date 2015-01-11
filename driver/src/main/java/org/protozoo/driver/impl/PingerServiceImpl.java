/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver.impl;

import java.io.IOException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.protozoo.driver.PingerService;

/**
 *
 * @author wolfgang
 */
public class PingerServiceImpl implements PingerService {

    private float frequency;
    
    static final String CONFIGURATION_PID = "org.protozoo.device.pinger";

    private final ConfigurationAdmin configAdmin;

    public PingerServiceImpl(ConfigurationAdmin configAdmin) {
        this.configAdmin = configAdmin;
    }

    @Override
    public float getFrequency() {
        return frequency;
    }

    @Override
    public void setFrequency(float freq) {
        this.frequency = freq;
    }
    
    private Configuration getConfiguration() {
        try {
            return configAdmin.getConfiguration(CONFIGURATION_PID, null);
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving Log information from config admin", e);
        }
    }
}
