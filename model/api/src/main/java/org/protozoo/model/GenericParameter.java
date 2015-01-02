/*
 * Copyright (C) 2014, Wizardofos.nl
 */

package org.protozoo.model;

import java.util.HashSet;
import java.util.Set;
import org.protozoo.core.item.AbstractItem;
import org.protozoo.core.type.State;
import org.protozoo.core.type.Type;
import org.protozoo.model.api.IDevice;
import org.protozoo.model.api.IMeasurement;
import org.protozoo.model.api.IParameter;

/**
 *
 * @author Wolfgang van Os
 */
public class GenericParameter extends AbstractItem implements IParameter {

    private IDevice device;
    private final Set<IMeasurement> measurements = new HashSet<>();

    public GenericParameter(String name) {
    }
      
    public void addMeasurement(GenericMeasurement measurement) {
        measurements.add(measurement);
    }
    
    public void removeParameter(GenericMeasurement measurement) {
        measurements.remove(measurement);
    }
    
    public int numberOfMeasurements() {
        return measurements.size();
    }

    @Override
    public void setDevice(IDevice device) {
        this.device = device;
    }

    @Override
    public IDevice getDevice() {
        return this.device;
    }

    @Override
    public boolean addMeasurement(IMeasurement measurement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeMeasurement(IMeasurement measurement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IMeasurement> getMeasurements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(State s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setType(Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
