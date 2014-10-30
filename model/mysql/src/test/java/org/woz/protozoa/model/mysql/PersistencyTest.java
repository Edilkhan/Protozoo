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

    MySQLRepository repo;
    
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
        repo = new MySQLRepository();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createLocationTest() {
        System.out.println("===================================");
        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        Transaction tx = repo.getPersistenceManager().currentTransaction();

        try {
            tx.begin();

            Location tloc = new Location("Testloc", "First test location");
            Device tdev = new Device("Testdev", "First test device");
            tdev.setLocation(tloc);
            tloc.getDevices().add(tdev);
            
            tloc.setType(Type.PHYSICAL);
            tloc.setState(State.ACTIVE);
            
            System.out.println("Persisting a new location");
            repo.addLocation(tloc);

            System.out.println("Persisting a new device");
            repo.addDevice(tdev);
 
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
            repo.getPersistenceManager().close();
        }
        System.out.println("");        
    }
}
