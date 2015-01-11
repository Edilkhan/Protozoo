package org.protozoo.model.mysql;


import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.xml.bind.annotation.XmlRootElement;
import org.protozoo.system.core.item.AbstractItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wolfgang
 */
@XmlRootElement
@PersistenceCapable(table = "Parameter")
@Inheritance(strategy = InheritanceStrategy.COMPLETE_TABLE)
public class Parameter extends AbstractItem {
    
}
