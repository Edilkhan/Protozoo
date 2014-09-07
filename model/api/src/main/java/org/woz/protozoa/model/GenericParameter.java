/*
 * Copyright (C) 2014, Wizardofos.nl
 */

package org.woz.protozoa.model;

import java.util.HashSet;
import java.util.Set;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;
import org.woz.protozoa.model.api.Device;
import org.woz.protozoa.model.api.Measurement;
import org.woz.protozoa.model.api.Parameter;

/**
 *
 * @author Wolfgang van Os
 */
public class GenericParameter extends AbstractItem implements Parameter {

    private Device device;
    private final Set<Measurement> measurements = new HashSet<>();

    public GenericParameter(String name) {
        super(name);
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
    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public Device getDevice() {
        return this.device;
    }

    @Override
    public boolean addMeasurement(Measurement measurement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeMeasurement(Measurement measurement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Measurement> getMeasurements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(State state) {
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
