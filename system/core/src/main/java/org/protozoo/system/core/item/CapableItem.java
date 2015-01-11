/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.system.core.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.protozoo.system.core.type.Capability;
import org.protozoo.system.core.type.Capable;
import org.protozoo.system.core.type.State;
import static org.protozoo.system.core.type.State.INACTIVE;
import org.protozoo.system.core.type.Stateful;

/**
 *
 * @author wolfgang
 */
public abstract class CapableItem extends AbstractItem implements Capable, Stateful {

    /**
     * By default, state is INACTIVE for each CapableItem
     */
    private State state = INACTIVE;

    /**
     * The list of capabilities of this item
     */
    private final List<Capability> capabilities = new ArrayList<>();

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public boolean addCapability(Capability c) {
        return capabilities.add(c);
    }

    @Override
    public boolean addCapability(Collection<Capability> clist) {
        return capabilities.addAll(clist);
    }

    @Override
    public boolean addCapability(Capability... clist) {
        boolean retval = false;

        for (Capability c : clist) {
            retval |= capabilities.add(c);
        }

        return retval;
    }

    @Override
    public boolean removeCapability(Capability c) {
        return capabilities.remove(c);
    }

    @Override
    public boolean hasCapability(Capability c) {
        return capabilities.contains(c);
    }

    @Override
    public Collection<Capability> getCapabilities() {
        return capabilities;
    }
}
