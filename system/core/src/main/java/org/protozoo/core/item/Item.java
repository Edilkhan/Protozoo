/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.core.item;

import java.util.Date;

/**
 * This is the base of all classes of the Protozoa framework
 * 
 * @author Wolfgang van Os
 */
public interface Item {

    /**
     * Retrieves the id of the item
     *
     * @return the id of the item
     */
    public String getId();
    
    public Date getCreatedTimestamp();
    
}
