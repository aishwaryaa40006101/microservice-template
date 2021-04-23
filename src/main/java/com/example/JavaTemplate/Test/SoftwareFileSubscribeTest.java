package com.example.JavaTemplate.Test;

import com.updates.SoftwareUpdatesLib.ISoftwareUpdates_Subscribe;
import com.updates.SoftwareUpdatesLib.Receive_Software_Updates_using_kafka;

public class SoftwareFileSubscribeTest {
    public SoftwareFileSubscribeTest() {
    }

    public static void main(String[] args) throws Exception {
        PropertiesCache prop = PropertiesCache.getInstance();
        String queueName1=prop.getProperty("ActiveMqQueueName1");
        String queueName2=prop.getProperty("ActiveMqQueueName2");
        String queueName3=prop.getProperty("ActiveMqQueueName3");
        String queueName4=prop.getProperty("ActiveMqQueueName4");
        String fileOutPutPath=prop.getProperty("FileOutPutByteDirectory");
        String fileInputPath=prop.getProperty("FileInputDirectory");
        String brokerurl=prop.getProperty("ActiveMQ-Broker-url");
        String kafkabrokerurl=prop.getProperty("Kafka-Broker-url");
        String topic1=prop.getProperty("topicNameKafka");
        String topic2=prop.getProperty("topicName");

       /* ISoftwareUpdates_Subscribe i = new Receive_Software_Updates_using_ActiveMQ(queueName1,queueName2,queueName3,queueName4);
        i.subscribe_Updates_File(fileOutPutPath,fileInputPath ,brokerurl );*/


       ISoftwareUpdates_Subscribe i1 = new Receive_Software_Updates_using_kafka(topic1,topic2 );
        i1.subscribe_Updates_File(fileOutPutPath, fileInputPath,kafkabrokerurl );
    }
}
