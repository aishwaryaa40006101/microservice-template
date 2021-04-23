package com.example.JavaTemplate.Test;

import com.updates.SoftwareUpdates.ISoftwareUpdates;
import com.updates.SoftwareUpdates.Publish_Software_Updates_using_Kafka;

public class SoftwareFilePublishTest {
    public SoftwareFilePublishTest() {
    }

    public static void main(String[] args) throws Exception {
        PropertiesCache prop = PropertiesCache.getInstance();
        String queueName1=prop.getProperty("ActiveMqQueueName1");
        String queueName2=prop.getProperty("ActiveMqQueueName2");

        String fileInputPath=prop.getProperty("FileInputDirectory");
        String brokerurl=prop.getProperty("ActiveMQ-Broker-url");
        String kafkabrokerurl=prop.getProperty("Kafka-Broker-url");
        String topic1=prop.getProperty("topicNameKafka");

       /* ISoftwareUpdates activemq = new Publish_Software_Updates_using_ActiveMQ(queueName1, queueName2);
        activemq.publish_Updates_File(brokerurl, fileInputPath);*/

        ISoftwareUpdates kafka = new Publish_Software_Updates_using_Kafka(topic1);
        kafka.publish_Updates_File(kafkabrokerurl, fileInputPath);
    }
}
