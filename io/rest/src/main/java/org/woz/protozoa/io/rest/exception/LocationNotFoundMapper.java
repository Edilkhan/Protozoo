/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author wos
 */
@Provider
public class LocationNotFoundMapper implements ExceptionMapper<LocationNotFoundException> {

    @Override
    public Response toResponse(LocationNotFoundException ex) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ex)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
