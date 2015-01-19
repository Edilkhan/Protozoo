/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wolfgang
 */
public class DriverTest {
    
    public DriverTest() {
    }
        
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDriver() {
        IDriver ping = new PingerDriver();
                
    }
}
