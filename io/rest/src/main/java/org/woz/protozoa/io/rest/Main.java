/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import javax.ws.rs.ext.ContextResolver;
import org.glassfish.grizzly.ssl.SSLContextConfigurator;
import org.glassfish.grizzly.ssl.SSLEngineConfigurator;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

/**
 *
 * @author wos
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "https://localhost:8080/protozoa/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in this package

        // final ResourceConfig rc = new ResourceConfig().packages("org.woz.protozoa.io.cxf.rest");
        final ResourceConfig rc = new ResourceConfig()
                .registerClasses(DevicesResourceImpl.class)
                .registerClasses(LocationsResourceImpl.class)
                .registerClasses(ContactResource.class)
                //.property(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE)
                // Providers - JSON
                .register(MoxyJsonFeature.class)
                .register(JsonConfiguration.class)
                .register(LocationNotFoundMapper.class);

        
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        // return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        SSLContextConfigurator sslCon = new SSLContextConfigurator();
        sslCon.createSSLContext();

//        sslCon.setKeyStoreFile(ConfigLoader.getKeystoreLocation()); // contains server keypair
//        sslCon.setKeyStorePass(ConfigLoader.getKeystorePassword());

        
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc, true, new SSLEngineConfigurator(sslCon, false, false, false));
    }

    /**
     * Main method.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdown();
    }

    /**
     * Configuration for
     * {@link org.eclipse.persistence.jaxb.rs.MOXyJsonProvider} - outputs
     * formatted JSON.
     */
    public static class JsonConfiguration implements ContextResolver<MoxyJsonConfig> {

        @Override
        public MoxyJsonConfig getContext(final Class<?> type) {
            final MoxyJsonConfig config = new MoxyJsonConfig();
            config.setFormattedOutput(true);
            return config;
        }
    }
}
