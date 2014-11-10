/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wolfgang
 */
@Path("contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
    
    Logger log = LoggerFactory.getLogger(ContactResource.class);
        
    @GET
    @Path("{id}")
    public Contact getContactAsJson(
        @PathParam("id") final Long id) {
        
        log.info("getContact called...");
        
        return new Contact(id);
    }

    /*
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getContactAsText(
        @PathParam("id") final Long id) {
        
        log.info("getContact called...");
        
        return Contact.getContact(id).toString();
    }
    */
}
