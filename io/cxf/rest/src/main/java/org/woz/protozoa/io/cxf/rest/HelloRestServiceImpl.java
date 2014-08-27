package org.woz.protozoa.io.cxf.rest;

import org.woz.protozoa.io.cxf.service.HelloService;

public class HelloRestServiceImpl implements HelloRestService{


    //Just like Spring.  Please add Getters/Setters. Blueprint annotations are still work in progress
    private HelloService helloService;

    @Override
    public String handleGet(String name){

        return helloService.sayHello(name);

    }


    /*
        Constructor
     */

    public HelloRestServiceImpl(){
    }

    /*
        Getters and Setters
     */

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

}
