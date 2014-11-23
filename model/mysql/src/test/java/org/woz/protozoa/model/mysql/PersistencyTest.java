/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woz.protozoa.core.item.Item;
import org.woz.protozoa.core.type.State;

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

/*    
    @Test
    public void testCreateGetDelete() {
        String namedloc = "TestLoc123";
        
        System.out.println("Create location: " + namedloc);
        Location loc = repo.addLocation(namedloc, "Test description 123");
        
        System.out.println("Find location: " + namedloc);
        loc = repo.getLocationByName(namedloc);
        
        System.out.println("Delete location: " + namedloc);
//        repo.removeLocation(namedloc);
    }
*/
    
    @Test
    public void testOne() {
        testCreateItem("NewLoc456");
        testGetItems(Location.class);
        testGetItemByName(Location.class, "NewLoc001");
        testDeleteItem("NewLoc456");
        testUpdateLocation("NewLoc001");        
    }
    
    public void testCreateItem(String name) {
        repo.createItem(new Location(name, "Location created by generic item"));
    }
    
    public void testDeleteItem(String name) {
        repo.deleteItemByName(Location.class, name);
    }
    
    public void testGetItems(Class clazz) {
        Collection<?> items = repo.getItems(clazz);
        
        System.err.println(items);
    }
    
    public Item testGetItemByName(Class clazz, String name) {
        Item item = repo.getItemByName(clazz, name);
        System.err.println(item);
        return item;
    }
    
    public void testUpdateLocation(String name) {
        Location loc = (Location) repo.getItemByName(Location.class, name);
        loc.setState(State.INACTIVE);
        repo.updateItem(loc);
    }
    
    /*
    @Test
    public void createLocationTest() {

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
    */
}
