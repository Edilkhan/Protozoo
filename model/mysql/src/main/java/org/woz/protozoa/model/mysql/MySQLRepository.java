/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.Collection;
import java.util.Properties;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import org.osgi.service.component.annotations.Component;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.model.api.IDevice;
import org.woz.protozoa.model.api.ILocation;
import org.woz.protozoa.model.api.Repository;

/**
 *
 * @author wos
 */
@Component
public class MySQLRepository implements Repository {

    Properties properties = new Properties();
    PersistenceManagerFactory pmf;

    public MySQLRepository() {
        // Create a PersistenceManagerFactory for this datastore

        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:mysql://localhost/nucleus");
        properties.setProperty("javax.jdo.option.ConnectionDriverName","com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionUserName","atomic");
        properties.setProperty("javax.jdo.option.ConnectionPassword","test");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");

        pmf = JDOHelper.getPersistenceManagerFactory(properties);
    }
    
    public PersistenceManager getPersistenceManager() {
        return pmf.getPersistenceManager();
    }

    @Override
    public ILocation addLocation(ILocation newloc) {
        Location loc = (Location)newloc;
        
        return getPersistenceManager().makePersistent(loc);
    }

    @Override
    public boolean removeLocation(String name) {
        
        Location loc = (Location) getLocation(name);
        
        if (loc != null) {
            getPersistenceManager().deletePersistent(loc);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ILocation getLocation(String name) {
        return (Location) getPersistenceManager().newQuery(Location.class, name).execute();
    }

    @Override
    public Collection<Item> getLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDevice addDevice(IDevice newdev) {
        Device dev = (Device)newdev;
        
        return getPersistenceManager().makePersistent(dev);
    }

    @Override
    public boolean removeDevice(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDevice getDevice(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Item> getDevices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
