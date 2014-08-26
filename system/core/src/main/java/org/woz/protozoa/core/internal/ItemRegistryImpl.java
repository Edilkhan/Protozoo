/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.core.Item;
import org.woz.protozoa.core.ItemRegistry;

/**
 *
 * @author Wolfgang van Os
 */
public class ItemRegistryImpl extends Observable implements ItemRegistry {

    private static final Logger logger = LoggerFactory.getLogger(ItemRegistryImpl.class);

    /**
     * HashMap of all registered objects in memory
     */
    protected Map<Item, Item> objects = new HashMap<>();
    
    @Override
    public org.woz.protozoa.core.Item getObject(Item key) {
        return objects.get(key);
    }

    @Override
    public Collection<org.woz.protozoa.core.Item> getObjects() {
        return objects.values();
    }
}
