/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.woz.protozoa.model.mysql;

import java.util.Collection;
import java.util.Properties;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.woz.protozoa.core.item.Item;

/**
 *
 * @author wos
 */
@Component
public class MySQLRepository  {

    Properties properties = new Properties();
    PersistenceManagerFactory pmf;
    static PersistenceManager pm;

    Logger log = LoggerFactory.getLogger(MySQLRepository.class);

    public MySQLRepository() {
        // Create a PersistenceManagerFactory for this datastore

        properties.setProperty("javax.jdo.PersistenceManagerFactoryClass", "org.datanucleus.api.jdo.JDOPersistenceManagerFactory");
        properties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:mysql://localhost/nucleus");
        properties.setProperty("javax.jdo.option.ConnectionDriverName", "com.mysql.jdbc.Driver");
        properties.setProperty("javax.jdo.option.ConnectionUserName", "atomic");
        properties.setProperty("javax.jdo.option.ConnectionPassword", "test");
        properties.setProperty("datanucleus.schema.autoCreateAll", "true");

        pmf = JDOHelper.getPersistenceManagerFactory(properties);

        log.info("MySQL repository created...");
    }

    public PersistenceManager getPersistenceManager() {
        if (pm == null) {
            pm = pmf.getPersistenceManager();
        }

        return pm;
    }

    public Item createItem(Item item) {
        log.info("Create item");

        Transaction tx = getPersistenceManager().currentTransaction();

        tx.begin();

        try {
        
            Item newitem = getPersistenceManager().makePersistent(item);

            tx.commit();

            return newitem;

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            return null;
        }
    }
    
    public Item getItemByName(Class clazz, String name) {

        try {

            Query q = getPersistenceManager()
                    .newQuery(clazz);
            q.setFilter("name == \"" + name + "\"");

            Collection<?> result = (Collection<?>) q.execute();

            return (Item) result.iterator().next();

        } catch (Exception e) {

            return null;
        }
    }
    
    public Collection<?> getItems(Class clazz) {
        Query query = getPersistenceManager().newQuery(clazz);

        Collection<Item> result = (Collection<Item>) query.execute();
        
        return result;
    }
    
    public Item updateItem(Item item) {
        Transaction tx = getPersistenceManager().currentTransaction();
        
        if (item != null) {
            tx.begin();
            getPersistenceManager().makePersistent(item);
            tx.commit();
            
            return item;
        } else {
            return null;
        }
    }
    
    public boolean deleteItem(Item item) {
        Transaction tx = getPersistenceManager().currentTransaction();

        if (item != null) {
            tx.begin();
            getPersistenceManager().deletePersistent(item);
            tx.commit();

            return true;
        } else {
            if (tx.isActive()) {
                tx.rollback();
            }

            return false;
        }
    }
    
    public boolean deleteItemByName(Class clazz, String name) {
        Item item  = getItemByName(clazz, name);
        
        if (item == null) {
            return false;
        } else {
            return deleteItem(item);
        }
    }
}
