/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.model.api;

import java.util.Calendar;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import org.protozoo.system.core.item.Item;

/**
 *
 * @author Wolfgang van Os
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public interface IMeasurement extends Item {
    
    public void setValue(Object value);
    public Object getValue();
    
    public void setTimestamp(Calendar timestamp);
    public Calendar getTimestamp();
    
    public void setParameter(IParameter parameter);
    public IParameter getParameter();
    
}
