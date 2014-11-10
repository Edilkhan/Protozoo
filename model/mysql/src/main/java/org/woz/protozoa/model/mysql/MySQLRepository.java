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
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wos
 */
@Component
public class MySQLRepository {

    Properties properties = new Properties();
    PersistenceManagerFactory pmf;
    static PersistenceManager pm;
    
    Logger log = LoggerFactory.getLogger(MySQLRepository.class);

    public MySQLRepository() {
        // Create a PersistenceManagerFactory for this datastore

        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:mysql://localhost/nucleus");
        properties.setProperty("javax.jdo.option.ConnectionDriverName","com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionUserName","atomic");
        properties.setProperty("javax.jdo.option.ConnectionPassword","test");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");

        pmf = JDOHelper.getPersistenceManagerFactory(properties);
        
        log.info("MySQL repository created...");
    }
    
    public PersistenceManager getPersistenceManager() {
        if (pm == null) {
            pm = pmf.getPersistenceManager();
        }
        
        return pm;
    }

    
    public Location addLocation(String name, String description) {

        Transaction tx = getPersistenceManager().currentTransaction();
 
        try {
            tx.begin();
            
            Location newloc = getPersistenceManager().makePersistent(new Location(name, description));
            
            tx.commit();
            
            return newloc;
            
        } catch (Exception e) {
            tx.rollback();
            
            return null;
        }
    }

    
    public boolean removeLocation(String name) {
        
        Location loc = (Location) getLocation(name);
        
        if (loc != null) {
            getPersistenceManager().deletePersistent(loc);
            return true;
        } else {
            return false;
        }
    }

    
    public Location getLocation(String name) {
        log.info("getLocation called...");
                
        return getPersistenceManager().getObjectById(Location.class, name);
    }

    
    public Collection<ILocation> getLocations() {
        log.info("getLocations called...");
        
        Query query = getPersistenceManager().newQuery(Location.class);
                
        return (Collection) query.execute();
    }

    
    public Device addDevice(String name, String description) {
        return getPersistenceManager().makePersistent(new Device(name, description));
    }

    
    public boolean removeDevice(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Device getDevice(String name) {
        log.info("getDevice called...");
                
        return getPersistenceManager().getObjectById(Device.class, name);
    }

    
    public Collection<Item> getDevices() {
        log.info("getDevices called...");
        
        Query query = getPersistenceManager().newQuery(Device.class);
                
        return (Collection) query.execute();
    }
}
