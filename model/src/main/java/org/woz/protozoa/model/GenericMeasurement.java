/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.woz.protozoa.core.item.AbstractItem;
import org.woz.protozoa.model.spi.Measurement;
import org.woz.protozoa.model.spi.Parameter;

/**
 *
 * @author Wolfgang van Os
 */
public class GenericMeasurement extends AbstractItem implements Measurement {
    
    private Object value;
    private Calendar timestamp;
    private Parameter parameter;
    
    public GenericMeasurement(String name) {
        this(name, null);
    }

    public GenericMeasurement(String name, String description) {
        super(name, description);
    }

    public GenericMeasurement(String name, Object value) {
        this(name, null);
        this.timestamp = Calendar.getInstance();
        this.value = value;
    } 

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return String.format("%s%s (%s)", "Measurement: ", value, 
                sdf.format(timestamp.getTime()));
    }

    @Override
    public Object getValue() {
        return this.value;
    }
    
    @Override
    public void setValue(Object value) {
        this.value = value;
    }
    
    @Override
    public Calendar getTimestamp() {
        return this.timestamp;
    }

    @Override
    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
    
    @Override
    public Parameter getParameter() {
        return this.parameter;
    }
}
