/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.io.rest;

import org.protozoo.model.mysql.Parameter;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.protozoo.io.rest.exception.CreateParameterFailedException;
import org.protozoo.io.rest.exception.DeleteParameterFailedException;
import org.protozoo.io.rest.exception.ParameterNotFoundException;
import org.protozoo.io.rest.exception.UpdateParameterFailedException;

/**
 *
 * @author wolfgang
 */
@Path("parameters")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ParametersResource {

    @GET
    public Response getParameters();

    @GET
    @Path("{uuid}")
    public Response getParameter(@PathParam("uuid") String uuid) throws ParameterNotFoundException;
 
    @GET
    @Path("{uuid}/values")
    public Response getValuesByParameter(@PathParam("uuid") String uuid) throws ParameterNotFoundException;

    @POST
    public Response createParameter(Parameter parameter) throws CreateParameterFailedException;

    @PUT
    public Response updateParameter(Parameter parameter) throws UpdateParameterFailedException;
    
    @DELETE
    @Path("uuid")
    public Response deleteParameter(@PathParam("uuid") String uuid) throws DeleteParameterFailedException;
}
