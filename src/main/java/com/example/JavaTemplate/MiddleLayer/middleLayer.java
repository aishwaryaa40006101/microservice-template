package com.example.JavaTemplate.MiddleLayer;

import LoggerLib.LoggerWrapper;
import com.activemq.ActivemqBroker.ActiveMQBroker;
import com.activemq.ActivemqBroker.IMessageBroker;

import com.activemq.ActivemqBroker.PropertiesCache;
import com.example.JavaTemplate.BusinessLayer.BusinessLogic;
import com.example.JavaTemplate.Cancellation.CancellationToken;
import com.example.JavaTemplate.Cancellation.CancellationTokenSource;
import com.example.JavaTemplate.Controller.HelloWorldController1;
import com.health.HealthIndicator101.Healthindicator;
import org.springframework.beans.factory.annotation.Autowired;


import javax.jms.JMSException;
import java.net.URISyntaxException;

public class middleLayer {
    private static IMessageBroker broker;
    private static PropertiesCache prop = PropertiesCache.getInstance();
    static LoggerWrapper mLogger = new LoggerWrapper("MiddleLayer1.class");
    public Healthindicator healthindicator =Healthindicator.getInstance();

    //Healthindicator healthindicator = new Healthindicator();
    private String message = "No Message";
    String brokerUrl=prop.getProperty("ActiveMQ-Broker-url");

    private BusinessLogic businessLogic;

    public void start(CancellationToken cancellationToken) throws URISyntaxException, JMSException {

        healthindicator.setStartService(1);
        CancellationTokenSource tokenSource = new CancellationTokenSource();

            try {
                broker = new ActiveMQBroker(brokerUrl);
                broker.connect("middle-layer");
                if (!broker.isConnected()) {
                    mLogger.error("Broker is not connected");
                    healthindicator.setMessageBrokerConnectionService(0);
                    healthindicator.setErrorService(1);
                    healthindicator.setHealthRemark("The service is not connected to message broker");
                } else {
                    healthindicator.setMessageBrokerConnectionService(1);
                    healthindicator.setHealthRemark("The service is connected to broker");
                    mLogger.info("Broker is connected");
                }
                while (!cancellationToken.isCancellationRequested()) {
                    try {
                        // int i= 2/0;
                        businessLogic = new BusinessLogic();
                        mLogger.info("Service is started");
                    } catch (Exception exception) {
                        //call start and stop lib to stop the service
                        mLogger.error(exception, "Exception from business logic layer");
                    } finally {
                        tokenSource.cancel();
                        cancellationToken = tokenSource.getToken();
                    }
                }
            } catch (Exception e) {
                mLogger.error(e, "Some exception");
            }

    }
}