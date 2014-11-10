/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.util.Collection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wos
 */
public class DeviceRestTest {
    
    private HttpServer server;
    private WebTarget target;
    
    public DeviceRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        server = Main.startServer();
        
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }
    
    @After
    public void tearDown() {
        server.shutdown();
    }
    
    @Test
    public void queryDevices() {
        Response result = target.path("devices").request().accept(MediaType.APPLICATION_JSON).get();
        //assertEquals("", devices);
        System.out.println(result);
    }
}
