/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.item;

/**
 *
 * @author Wolfgang van Os
 */
public interface ItemFactory {

    /**
     * Creates a new Item instance of type <code>typeName</code> and the
     * name <code>objectName</code>
     *
     * @param typeName
     * @param objectName
     * @return a new Item of type <code>itemTypeName</code> or <code>null</code>
     * if no matching class is known.
     */
    Item create(String typeName, String objectName);

    /**
     * Returns the list of all supported types of this factory.
     *
     * @return the supported types
     */
    String[] getSupportedTypes();
}
