/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import org.protozoo.io.rest.Main;
import java.util.Collection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author wos
 */
public class LocationRestTest {

    private HttpServer server;
    private WebTarget target;

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
    public void getTestLocation() {
        //String response = target.path("locations/Testloc").request().get(String.class);

        //System.out.println("Location: " + response);
        //assertEquals("{ Testloc, First test location, ACTIVE, PHYSICAL }", response);
    }

    @Test
    public void getAllLocations() {
        //String responseMsg = target.path("locations").request().get(Collection.class);

        //System.out.println("All locations: " + responseMsg);
    }

    /*
    @Test
    public void createTestLocation() {
        target.path("locations/new")
                .queryParam("name", "ProtoLoc")
                .queryParam("description", "Just a test location")
                .request()
                .post(null);
    }
    */
}
