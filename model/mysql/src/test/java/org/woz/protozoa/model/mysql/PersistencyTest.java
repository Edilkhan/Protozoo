/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.Properties;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woz.protozoa.core.type.State;
import org.woz.protozoa.core.type.Type;

/**
 *
 * @author wos
 */
public class PersistencyTest {

    Properties properties = new Properties();
    PersistenceManagerFactory pmf;
    
    public PersistencyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Create a PersistenceManagerFactory for this datastore
        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:mysql://localhost/nucleus");
        properties.setProperty("javax.jdo.option.ConnectionDriverName","com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionUserName","atomic");
        properties.setProperty("javax.jdo.option.ConnectionPassword","test");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");

        pmf = JDOHelper.getPersistenceManagerFactory(properties);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createLocationTest() {
        System.out.println("===================================");
        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a Product and a Book.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        Object locationId = null;
        try {
            tx.begin();

            Location tloc = new Location("Testloc", "First test location");
            Device tdev = new Device("Testdev", "First test device");
            tdev.setLocation(tloc);
            tloc.getDevices().add(tdev);
            
            tloc.setType(Type.PHYSICAL);
            tloc.setState(State.ACTIVE);
            
            System.out.println("Persisting a new location");
            pm.makePersistent(tloc);

            System.out.println("Persisting a new device");
            pm.makePersistent(tdev);
 
            tx.commit();
            
            System.out.println("Completed!");
        }
        catch (Exception e)
        {
            System.out.println("Exception persisting data : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");        
    }
}
