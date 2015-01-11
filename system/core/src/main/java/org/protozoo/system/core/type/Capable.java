/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.system.core.type;

import java.util.Collection;

/**
 *
 * @author wolfgang
 */
public interface Capable {

    public boolean addCapability(Capability c);
    public boolean addCapability(Collection<Capability> clist);
    public boolean addCapability(Capability... clist);
    public boolean removeCapability(Capability c);
    public boolean hasCapability(Capability c);
    public Collection<Capability> getCapabilities();
}
