/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.item;

import java.util.Observable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * An abstract implementation of the Item interface, which includes the
 * capability of being @{Observable}
 *
 * @author Wolfgang van Os
 */
@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public abstract class AbstractItem extends Observable implements Item {

    @PrimaryKey
    protected String id;

    protected AbstractItem() {
        // Satisfy JDO
    }
    
    public AbstractItem(String id) {
        this.id = id;
    }

    /**
     * This is a generic <code>toString</code> method which outputs the name of
     * the class and the name and description of the instance.
     *
     * @return the string representation of this item
     */
    @Override
    public String toString() {
        return String.format("%s id=%s", this.getClass().getName(), id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
        setChanged();
        notifyObservers();
    }

}
