/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.item;

import java.util.Observable;
import javax.jdo.annotations.PersistenceCapable;

/**
 * An abstract implementation of the Item interface, which includes the
 * capability of being @{Observable}
 *
 * @author Wolfgang van Os
 */
@PersistenceCapable
public abstract class AbstractItem extends Observable implements Item {

    protected String name;
    protected String description;

    protected AbstractItem() {
        
    }
    
    public AbstractItem(String name) {
        this.name = name;
    }

    public AbstractItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * This is a generic <code>toString</code> method which outputs the name of
     * the class and the name and description of the instance.
     *
     * @return the string representation of this item
     */
    @Override
    public String toString() {
        return String.format("%s name=%s, description=%s", this.getClass().getName(), name, description);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
        setChanged();
        notifyObservers();
    }
}
