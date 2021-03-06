/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.driver.command;

import org.apache.karaf.bundle.core.BundleService;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.apache.karaf.shell.support.table.ShellTable;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.protozoo.driver.AbstractDriver;

/**
 *
 * @author wos
 */
@Command(scope = "driver", name = "list", description = "Lists all registered drivers.")
@Service
public class ListAction extends DMCommand {

    @Reference
    BundleContext bundleContext;

    @Reference
    BundleService bundleService;

    @Override
    protected void executeOnService(ServiceReference reference) throws Exception {
    }

    @Override
    protected Object doExecute(ServiceReference[] refs) throws Exception {
        
        ShellTable table = new ShellTable();
        table.column("ID");
        table.column("Category");
        
        for (ServiceReference reference : refs) {
            
            AbstractDriver item = (AbstractDriver) bundleContext.getService(reference);
            
            table.addRow().addContent(item.getId(),
                    item.getCategory());
        }
        table.print(System.out, true);
        
        return null;
    }

}
