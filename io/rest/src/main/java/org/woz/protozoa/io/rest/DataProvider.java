/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.message.MessageUtils;

/**
 *
 * @author wos
 */
public abstract class DataProvider implements MessageBodyWriter, MessageBodyReader {

    //private static final Logger LOG = Logger.getLogger(DataProvider.class.getName());

    @Provider
    @Consumes("text/plain")
    @Produces("text/plain")
    public static class TextPlain extends DataProvider {

        @Override
        public void writeTo(final Object t, final Class type, final Type genericType, final Annotation[] annotations,
                            final MediaType mediaType, final MultivaluedMap httpHeaders, final OutputStream entityStream)
                throws IOException, WebApplicationException {
            entityStream.write(t.toString().getBytes(MessageUtils.getCharset(mediaType)));
        }

        @Override
        public Object readFrom(final Class type, final Type genericType, final Annotation[] annotations,
                               final MediaType mediaType, final MultivaluedMap httpHeaders, final InputStream entityStream)
                throws IOException, WebApplicationException {
            //return new ClipboardData(readStringFromStream(entityStream, MessageUtils.getCharset(mediaType)));
            return null;
        }
    }

    @Provider
    @Consumes("application/json")
    @Produces("application/json")
    public static class ApplicationJson extends DataProvider {

        private static final String JsonOpenning = "{\"content\":\"";
        private static final String JsonClosing = "\"}";

        @Override
        public void writeTo(final Object t, final Class type, final Type genericType, final Annotation[] annotations,
                            final MediaType mediaType, final MultivaluedMap httpHeaders, final OutputStream entityStream)
                throws IOException, WebApplicationException {
            entityStream.write(String.format("%s%s%s", JsonOpenning, t.toString(), JsonClosing)
                    .getBytes(MessageUtils.getCharset(mediaType)));
        }

        @Override
        public Object readFrom(final Class type, final Type genericType, final Annotation[] annotations,
                               final MediaType mediaType, final MultivaluedMap httpHeaders, final InputStream entityStream)
                throws IOException, WebApplicationException {
            final String jsonExpression = readStringFromStream(entityStream, MessageUtils.getCharset(mediaType));
            //return new ClipboardData(jsonExpression.replace(JsonOpenning, "").replace(JsonClosing, ""));
            return null;
        }
    }

    @Override
    public boolean isWriteable(final Class type, final Type genericType, final Annotation[] annotations,
                               final MediaType mediaType) {
        return isKnownType(type);
    }

    private boolean isKnownType(final Class<?> type) {
        //return type.isAssignableFrom(ClipboardData.class);
        return true;
    }

    @Override
    public long getSize(final Object t, final Class type, final Type genericType, final Annotation[] annotations,
                        final MediaType mediaType) {
        return -1;
    }

    @Override
    public boolean isReadable(final Class type, final Type genericType, final Annotation[] annotations,
                              final MediaType mediaType) {
        return isKnownType(type);
    }

    private static String readStringFromStream(final InputStream entityStream, Charset charset) throws IOException {
        final StringBuilder result = new StringBuilder();
        final byte[] buf = new byte[2048];
        int i;
        while ((i = entityStream.read(buf)) != -1) {
            result.append(new String(buf, 0, i, charset));
        }
        return result.toString();
    }
}
