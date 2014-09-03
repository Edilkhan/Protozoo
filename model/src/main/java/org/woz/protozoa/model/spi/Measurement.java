/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.model.spi;

import java.util.Calendar;
import org.woz.protozoa.core.item.Item;

/**
 *
 * @author Wolfgang van Os
 */
public interface Measurement extends Item {
    
    public void setValue(Object value);
    public Object getValue();
    
    public void setTimestamp(Calendar timestamp);
    public Calendar getTimestamp();
    
    public void setParameter(Parameter parameter);
    public Parameter getParameter();
}
