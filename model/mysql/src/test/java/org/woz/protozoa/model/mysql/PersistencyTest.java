/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import org.protozoo.model.mysql.Location;
import org.protozoo.model.mysql.MySQLRepository;
import org.protozoo.model.mysql.Device;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.protozoo.system.core.item.Item;
import org.protozoo.system.core.type.State;

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
    public void testLocations() {
        testCreateLocation("NewLoc456");
        testGetItems(Location.class);
        testGetItemByName(Location.class, "NewLoc001");
        testUpdateLocation("NewLoc456");
        testDeleteLocation("NewLoc456");

        testGetDevices((Location) testGetItemByName(Location.class, "ForDev"));
    }

    @Test
    public void testDevices() {
        testCreateDevice("NewDev123");
        testGetItems(Device.class);
        testGetItemByName(Device.class, "NewDev123");
        //testDeleteDevice("NewDev123");
        //testUpdateDevice("NewLoc001");
    }
    
    public void testCreateLocation(String name) {
        repo.createItem(new Location(name, "Location created by generic item"));
    }

    public void testDeleteLocation(String name) {
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

    public void testCreateDevice(String name) {
        Device d = new Device(name, "Device created by generic item");
        
        Location l = new Location("ForDev");
        
        d.setLocation(l);
        
        repo.createItem(d);
        
    }

    public void testDeleteDevice(String name) {
        repo.deleteItemByName(Device.class, name);
    }
    
    public void testGetDevices(Location l) {
        System.out.println("Query: " + repo.getItemsByQuery(Device.class, "location.id == \"" + l.getId() + "\""));        
    }
}
