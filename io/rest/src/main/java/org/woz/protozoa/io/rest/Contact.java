/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.io.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wolfgang
 */
@XmlRootElement
public class Contact {

    @XmlElement
    private final Long id;
    @XmlElement
    private final String name = "Maestro";

    private Contact() {
        id = 0L;
    }
    
    public Contact(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact: " + name + "(" + id + ")";
    }
}
