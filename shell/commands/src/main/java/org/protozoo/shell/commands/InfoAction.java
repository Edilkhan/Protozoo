/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.protozoo.shell.commands;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.fusesource.jansi.Ansi;

/**
 *
 * @author wolfgang
 */
@Command(scope = "protozoo", name = "info", description = "Prints general information.")
@Service
public class InfoAction implements Action {

    @Override
    public Object execute() throws Exception {
        int maxNameLen = 25;

        //
        // print Protozoa informations
        //
        System.out.println("Protozoa");
        printValue("Protozoa version", maxNameLen, System.getProperty("protozoa.version"));
        printValue("Protozoa home", maxNameLen, System.getProperty("protozoa.home"));
        printValue("Protozoa base", maxNameLen, System.getProperty("protozoa.base"));
        System.out.println();

        return null;
    }


    void printSysValue(String prop, int pad) {
        printValue(prop, pad, System.getProperty(prop));
    }

    void printValue(String name, int pad, String value) {
        System.out.println(Ansi.ansi().a("  ")
                .a(Ansi.Attribute.INTENSITY_BOLD).a(name).a(spaces(pad - name.length())).a(Ansi.Attribute.RESET)
                .a("   ").a(value).toString());
    }

    String spaces(int nb) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nb; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

}
