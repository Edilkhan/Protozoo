/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.woz.protozoa.io.cxf.rest;

/**
 *
 * @author wos
 */
public class RestServiceImpl implements RestService {

        @Override
	public String sayHello() {
		return "Protozoa REST services says hello!";
	}
}