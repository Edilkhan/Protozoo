/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woz.protozoa.model.api.Database;
import org.woz.protozoa.model.api.Factory;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wos
 */
public class FactoryImplTest {
    
    private Factory factory;
    private Database db;
    
    public FactoryImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        factory = new FactoryImpl();
        db = factory.getDatabase();
    }
    
    @After
    public void tearDown() {
        db = null;
        factory = null;
    }

    @Test
    public void testAddAndRemoval() {
        
        int oldsize = db.size();
        
        ILocation testloc = new GenericLocation("Test", "Test location");
        assertNull(db.addLocation(testloc));
        assertSame(db.size(), oldsize + 1);
        
        assertTrue(db.removeLocation("Test"));
        assertSame(db.size(), oldsize);
        
    }
    
    @Test
    public void testGetLocation() {
        
        ILocation home = new GenericLocation("Home", "No place like it...");
        
        assertNull(db.addLocation(home));        
        assertEquals(db.getLocation("Home").getName(),"Home");
        
    }
}
