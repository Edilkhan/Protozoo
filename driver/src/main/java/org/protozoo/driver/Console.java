/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver;

import org.osgi.framework.BundleContext;

/**
 *
 * @author wolfgang
 */
public class Console {
    
    private int port;
    private final BundleContext context;

    public Console(BundleContext context) {
        this.context = context;
    }
    
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
