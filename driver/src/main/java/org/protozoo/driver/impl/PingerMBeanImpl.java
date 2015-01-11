/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver.impl;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;
import org.protozoo.driver.PingerMBean;
import org.protozoo.driver.PingerService;

/**
 *
 * @author wolfgang
 */
public class PingerMBeanImpl extends StandardMBean implements PingerMBean {

    private final PingerService pingerService;

    public PingerMBeanImpl(PingerService pingerService) throws NotCompliantMBeanException {
        super(PingerMBean.class);
        this.pingerService = pingerService;
    }

    @Override
    public float getFrequency() {
        return pingerService.getFrequency();
    }

    @Override
    public void setFrequency(float freq) {
        pingerService.setFrequency(freq);
    }
}