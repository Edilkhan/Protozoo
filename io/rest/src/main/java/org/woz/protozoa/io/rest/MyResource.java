/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author wos
 */
@Singleton
@Path("myresource")
public class MyResource {
    
    private String restStr = "Got it!";
    
    /**
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return restStr;
    }
    
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public Response putString(@Context HttpHeaders httpHeaders) {
        System.out.println("PUT method");
        System.out.println(httpHeaders.getAcceptableMediaTypes());
        
        restStr = "Hello World!";
        
        return Response.accepted().build();
    }
}
