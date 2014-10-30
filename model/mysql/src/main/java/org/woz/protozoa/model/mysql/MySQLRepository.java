/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.Properties;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import org.osgi.service.component.annotations.Component;
import org.woz.protozoa.model.api.Repository;

/**
 *
 * @author wos
 */
@Component
public class MySQLRepository implements Repository {

    Properties properties = new Properties();
    PersistenceManagerFactory pmf;

    public MySQLRepository() {
        // Create a PersistenceManagerFactory for this datastore

        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("javax.jdo.option.ConnectionURL","jdbc:mysql://localhost/nucleus");
        properties.setProperty("javax.jdo.option.ConnectionDriverName","com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionUserName","atomic");
        properties.setProperty("javax.jdo.option.ConnectionPassword","test");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");

        pmf = JDOHelper.getPersistenceManagerFactory(properties);
    }
    
    public PersistenceManager getPersistenceManager() {
        return pmf.getPersistenceManager();
    }
}
