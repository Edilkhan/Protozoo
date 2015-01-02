/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.io.rest.exception;

/**
 *
 * @author wos
 */
public class DeviceNotFoundException extends Exception {

    public DeviceNotFoundException() {
        super();
    }
    
    public DeviceNotFoundException(String message) {
        super(message);
    }
    
}
