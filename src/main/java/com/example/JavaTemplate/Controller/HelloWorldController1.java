package com.example.JavaTemplate.Controller;

import LoggerLib.LoggerWrapper;
import com.example.JavaTemplate.BusinessLayer.BusinessLogic;
import com.example.JavaTemplate.OuterLayer.outerLayer;
import com.health.HealthIndicator101.Healthindicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController1 {
   // BusinessLogic logic =new BusinessLogic();
   // middleLayer middleLayer1 = new middleLayer();
    com.example.JavaTemplate.OuterLayer.outerLayer outerLayer = new outerLayer();
    static LoggerWrapper mLogger = new LoggerWrapper("BusinessLogic.class");
    public Healthindicator healthindicator = Healthindicator.getInstance();

    public HelloWorldController1() throws Exception {
        /*try{
            WepPage();
            GettingIntoBusinessLogic();
        } catch (Exception e) {
            throw e;
        }*/
    }

    public String showHelloWorldOnPage(){

        return "Hello World";

    }

    @GetMapping("/welcomeToHomePage")
    public String WepPage() throws Exception {
        try {
            int j = 2 / 0;
            String msg = showHelloWorldOnPage();
            return msg;
        }
        catch(Exception e)
        {
            throw e;
        }
    }


    @GetMapping("/getInstance")
    public String GettingIntoBusinessLogic()
    {
        try {
            System.out.println("Into the business part of the service.......");
            //healthindicator.setRunningService(1);
            mLogger.info("Service is running");
            System.out.println("Add business logic here");
            String msg = showHelloWorldOnPage();
            return msg;
        }
        catch(Exception e)
        {
            throw e;
        }
    }

}
