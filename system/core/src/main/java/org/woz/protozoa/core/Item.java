/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core;

/**
 * This is the base of all classes of the Protozoa framework
 * 
 * @author Wolfgang van Os
 */
public interface Item {

    /**
     * Sets the name of the item
     *
     * @param name of the item
     */
    public void setName(String name);

    /**
     * Retrieves the name of the item
     *
     * @return the name of the item
     */
    public String getName();

    /**
     * Sets the description of the item
     *
     * @param description of the item
     */
    public void setDescription(String description);

    /**
     * Retrieves the description of the item
     *
     * @return the description of the item
     */
    public String getDescription();
    
}
