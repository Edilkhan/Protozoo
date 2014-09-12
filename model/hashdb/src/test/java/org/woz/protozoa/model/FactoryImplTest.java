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
import org.woz.protozoa.model.api.Factory;
import org.woz.protozoa.model.api.Location;

/**
 *
 * @author wos
 */
public class FactoryImplTest {
    
    private Factory factory;
    
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
    }
    
    @After
    public void tearDown() {
        factory = null;
    }

    @Test
    public void testCreateLocation() {
        System.out.println(factory);
        
        Location testLoc = factory.createLocation("Test");
        assertEquals(testLoc.getName(), "Test");
    }
}
