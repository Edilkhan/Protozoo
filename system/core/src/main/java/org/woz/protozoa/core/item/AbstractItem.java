/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.woz.protozoa.core.item;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.UUID;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Column;

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
    @Column(name = "created")
    protected Date createdTimestamp;

    protected AbstractItem() {
        // Satisfy JDO
        this.id = UUID.randomUUID().toString();
        this.createdTimestamp = Calendar.getInstance().getTime();
    }
    
    /**
     * This is a generic <code>toString</code> method which outputs the name of
     * the class and the name and description of the instance.
     *
     * @return the string representation of this item
     */
    @Override
    public String toString() {
        return String.format("%s id={%s}, created %s", this.getClass().getName(), id, createdTimestamp);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getCreatedTimestamp() {
        return this.createdTimestamp;
    }
}
