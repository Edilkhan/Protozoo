/*
 * Copyright (C) 2014, Wizardofos.nl
 */
package org.protozoo.core.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.protozoo.core.type.Capability;
import org.protozoo.core.type.Capable;
import org.protozoo.core.type.State;
import static org.protozoo.core.type.State.INACTIVE;
import org.protozoo.core.type.Stateful;

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
        dump("State is set to " + state);
        this.state = state;
    }

    @Override
    public State getState() {
        dump("State = " + state);
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

    // Prints the specified message to the system output
    private void dump(String msg) {
        System.out.println("[DEVICE] " + msg);
    }
}
