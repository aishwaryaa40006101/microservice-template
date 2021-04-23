package com.example.JavaTemplate.BusinessLayer;

import LoggerLib.LoggerWrapper;

import com.example.JavaTemplate.Controller.HelloWorldController1;
import com.health.HealthIndicator101.Healthindicator;


public class BusinessLogic {
    static LoggerWrapper mLogger = new LoggerWrapper("BusinessLogic.class");
    public Healthindicator healthindicator = Healthindicator.getInstance();
    public BusinessLogic() throws Exception {
        System.out.println("Into the business part of the service.......");
        healthindicator.setRunningService(1);
        mLogger.info("Service is running");
        System.out.println("Add business logic here");
       try {
            HelloWorldController1 controller = new HelloWorldController1();
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public String helloWorld(String message)
    {
       return message;
    }
}
