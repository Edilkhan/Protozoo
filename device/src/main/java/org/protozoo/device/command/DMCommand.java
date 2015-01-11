/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.device.command;

import java.util.ArrayList;
import java.util.List;
import org.apache.karaf.bundle.core.BundleService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.support.MultiException;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.device.Device;

/**
 *
 * @author wolfgang
 */
public abstract class DMCommand implements Action {

    @Option(name = "--context", aliases = {"-c"}, description = "Use the given bundle context")
    String context = "0";

    @Argument(index = 0, name = "ids", description = "The list of bundle (identified by IDs or name or name/version) separated by whitespaces", required = false, multiValued = true)
    List<String> ids;

    @Reference
    BundleContext bundleContext;

    @Reference
    BundleService bundleService;

    protected boolean defaultAllBundles = true;

    protected String errorMessage = "Unable to execute command on bundle ";

    @Override
    public Object execute() throws Exception {
        List<Bundle> bundles =  bundleService.selectBundles(context, ids, defaultAllBundles);
        
        ServiceReference refs[] = bundleContext.getAllServiceReferences(Device.class.getName(), null);
        return doExecute(refs);
    }

    protected Object doExecute(ServiceReference[] refs) throws Exception {
        if (refs.length == 0) {
            throw new IllegalArgumentException("No matching services");
        }
        List<Exception> exceptions = new ArrayList<>();
        for (ServiceReference reference : refs) {
            try {
                executeOnService(reference);
            } catch (Exception e) {
                exceptions.add(new Exception(errorMessage + reference.getBundle().getBundleId() + ": " + e.getMessage(), e));
            }
        }
        MultiException.throwIf("Error executing command on bundles", exceptions);
        return null;
    }

    protected abstract void executeOnService(ServiceReference reference) throws Exception;

}
