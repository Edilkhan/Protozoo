/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.io.rest.exception;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wos
 */

@XmlRootElement
public class LocationNotFoundException extends Exception {

    public LocationNotFoundException(String message) {
        super(message);
    }
}
