package com.example.JavaTemplate.Test;

import com.health.HealthIndicator101.Healthindicator;
import org.junit.Test;

public class HealthTest {
    PropertiesCache prop = new PropertiesCache();
    public HealthTest() {
    }

    @Test
   public void contextLoads1() {

        String brokerurl = prop.getProperty("ActiveMQ-Broker-url");
        String queuename = prop.getProperty("HealthQueueName");
        Healthindicator health = new Healthindicator();
        health.setDBConnectionService(1);
        health.setErrorService(0);
        health.setFaultService(1);
        health.setMessageBrokerConnectionService(1);
        health.setPublishData_To_MessageBroker_Service(1);
        health.setRunningService(1);
        health.setSendData_To_DB_Service(0);
        health.setStartService(1);
        health.setSERVICE_NAME("test");
        health.setSubscribeData_To_MessageBroker_Service(0);
        Boolean value = health.SendHealth(health, queuename, brokerurl);
        System.out.println(value);
    }
}
