/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.services.model;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Requires;

/**
 * Component that is a client to the Location services
 * 
 * @author wolfgang
 */
@Component(name = "AnnotatedClient", immediate = true)
@Instantiate
public class LocationClient {
    @Requires
    Location location;
    
}
