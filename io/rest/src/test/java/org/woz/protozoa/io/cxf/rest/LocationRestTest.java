/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.cxf.rest;

import org.woz.protozoa.io.rest.Main;
import javax.jdo.PersistenceManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.woz.protozoa.model.mysql.MySQLRepository;

/**
 *
 * @author wos
 */
public class LocationRestTest {
    
    MySQLRepository repo = new MySQLRepository();
    PersistenceManager pm;
    HttpServer server;
    
    @Before
    public void setUp() throws Exception {
        pm = repo.getPersistenceManager();
        server = Main.startServer();
    }
    
    @After
    public void tearDown() {
        pm.close();
        server.shutdown();
    }
    
    @Test
    public void getAllLocations() {
        
    }
    
}
