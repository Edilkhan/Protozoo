/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

/**
 *
 * @author wolfgang
 */
public interface Location {
    
    public void setName(String name);
    public String getName();
    public void setDescription(String description);
    public String getDescription();
    
    public void setState(State state);
    public State getState();
    public void setType(Type type);
    public Type getType();
    
    @Override
    public String toString();
}
