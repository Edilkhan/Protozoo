/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.woz.protozoa.model.api.ILocation;

/**
 *
 * @author wos
 */
@Produces({ "application/xml", "text/html" })
public class LocationMessageBodyWriter implements MessageBodyWriter<ILocation> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediatype) {
        return type == ILocation.class;
    }

    @Override
    public long getSize(ILocation bean, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // Deprecated in JAX-RS 2.0
        return 0;
    }

    @Override
    public void writeTo(ILocation bean, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ILocation.class);

            // serialize the entity myBean to the entity output stream
            jaxbContext.createMarshaller().marshal(bean, entityStream);
        } catch (JAXBException jaxbException) {
            throw new ProcessingException("Error serializing a Location to the output stream", jaxbException);
        }
    }
}
