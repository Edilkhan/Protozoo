/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author wos
 */
//@Path("rest")
public interface RestService {

    @GET
    @Path("hello/{name}")
    public String handleGet(@PathParam("name") String name);

}
