/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.item;

import java.util.Collection;

/**
 *
 * @author Wolfgang van Os
 */
public interface ItemRegistry {

    /**
     * This method retrieves a single object from the registry.
     *
     * @param key of the object
     * @return the identified object
     */
    public Item getObject(Item key);

    /**
     * This method retrieves all objects that are currently available in the
     * registry
     *
     * @return a collection of all available objects
     */
    public Collection<Item> getObjects();

}
