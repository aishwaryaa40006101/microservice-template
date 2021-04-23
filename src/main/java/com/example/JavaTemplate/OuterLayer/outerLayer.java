package com.example.JavaTemplate.OuterLayer;
import LoggerLib.LoggerWrapper;
import com.example.JavaTemplate.Cancellation.CancellationToken;
import com.example.JavaTemplate.MiddleLayer.middleLayer;
import com.example.JavaTemplate.Test.PropertiesCache;
import com.health.HealthIndicator101.Healthindicator;

import com.updates.SoftwareUpdates.ISoftwareUpdates;
import com.updates.SoftwareUpdates.Publish_Software_Updates_using_ActiveMQ;
import com.updates.SoftwareUpdatesLib.ISoftwareUpdates_Subscribe;
import com.updates.SoftwareUpdatesLib.Receive_Software_Updates_using_ActiveMQ;

import javax.jms.JMSException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class outerLayer extends Thread {
    static LoggerWrapper mLogger = new LoggerWrapper("outerLayer1.class");
    PropertiesCache prop = PropertiesCache.getInstance();
    String queueName1 = prop.getProperty("ActiveMqQueueName1");
    String queueName2 = prop.getProperty("ActiveMqQueueName2");
    String queueName3 = prop.getProperty("ActiveMqQueueName3");
    String queueName4 = prop.getProperty("ActiveMqQueueName4");
    String fileOutPutPath = prop.getProperty("FileOutPutByteDirectory");
    String fileInputPath = prop.getProperty("FileInputDirectory");
    String brokerurl = prop.getProperty("ActiveMQ-Broker-url");
    String kafkabrokerurl = prop.getProperty("Kafka-Broker-url");
    String topic1 = prop.getProperty("topicNameKafka");
    String topic2 = prop.getProperty("topicName");

    public void mainController() throws Exception {
        mLogger.info("Outer Layer of the Microservice");
        Boolean startFlag = RunStartStop();
        if (startFlag)
        {
            mLogger.info("Start and stop service is running/ User input is N");
        }

        CancellationToken token = new CancellationToken();
        middleLayer controller = new middleLayer();
         controller.start(token);
    }

    public Boolean RunStartStop() throws InterruptedException, IOException, JMSException, URISyntaxException {
        Boolean StartStopFlag = false;
        Boolean updatesFlag = PublishSoftwareUpdateFileToStartAndStop();
        if (updatesFlag){
            try {
                //Take the user input
                Scanner sc = new Scanner(System.in);
                System.out.println("Software update file is available, do you want to update the software(Y/N):");
                String input = sc.nextLine();
                if (input.contentEquals("Y")) {
                   /* StartAndStop stopAndStart = new StartAndStop(); //Use start and stop instance
                    Boolean stop = stopAndStart.Stop(); //to stop the service
                    if (stop) {
                        StartStopFlag = stopAndStart.Restart();//Restart the service by updating the software
                    } else {
                        //unable to stop the service
                        StartStopFlag=false;
                    }*/
                    StartStopFlag=true;
                } else {
                    //continue with the service.
                    StartStopFlag=true;
                }
            } catch (Exception exception) {
                //Exception in start and stop lib
                StartStopFlag=false;
            }
            return StartStopFlag;
        }
        else {
        return StartStopFlag;
        }

    }

        public Boolean PublishSoftwareUpdateFileToStartAndStop() throws URISyntaxException, IOException, InterruptedException, JMSException {
            Boolean value = false;
            Boolean publishSoftwareUpdateFileFlag = PublishSoftwareUpdateFile();
            if (publishSoftwareUpdateFileFlag) {
                try {
                    ISoftwareUpdates_Subscribe subscribe = new Receive_Software_Updates_using_ActiveMQ(queueName1, queueName2, queueName3, queueName4);
                    value = subscribe.subscribe_Updates_File(fileOutPutPath, fileInputPath, brokerurl);

                    /* ISoftwareUpdates_Subscribe subscribe = new Receive_Software_Updates_using_kafka(topic1,topic2 );
                    value=subscribe.subscribe_Updates_File(fileOutPutPath, fileInputPath,kafkabrokerurl );*/
                    return value;
                } catch (InterruptedException | JMSException | URISyntaxException e) {
                    return false;
                }

            } else {
                return value;
            }
        }

    public Boolean PublishSoftwareUpdateFile()
    {
        Boolean value = false;
        try {
            ISoftwareUpdates activemq = new Publish_Software_Updates_using_ActiveMQ(queueName1, queueName2);
            value =activemq.publish_Updates_File(brokerurl, fileInputPath);

            /*ISoftwareUpdates kafka = new Publish_Software_Updates_using_Kafka(topic1);
            value=kafka.publish_Updates_File(kafkabrokerurl, fileInputPath);*/
            return value;

        } catch (InterruptedException | JMSException | URISyntaxException e) {
            return false;
        }
    }
}
