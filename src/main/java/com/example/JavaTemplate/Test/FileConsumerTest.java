package com.example.JavaTemplate.Test;

import com.msgs.kafka.Imessagebroker;
import com.msgs.kafka.KafkaBroker;

import java.io.IOException;

public class FileConsumerTest {

    public static void main(String[] args) throws InterruptedException, IOException {


        PropertiesCache properties2 = PropertiesCache.getInstance();


        String server=properties2.getProperty("Kafka-Broker-url");
        String topic=properties2.getProperty("topicName");
        String outputfilepath= properties2.getProperty("FileOutPutByteDirectory");
        String filetopic=properties2.getProperty("fileTopic");



        System.out.println("kafka consumer");


        Imessagebroker msgbroker = (Imessagebroker) new KafkaBroker(server);

        System.out.println("Subscribed to topic:"+topic);

        msgbroker.Subscribe(filetopic);

        msgbroker.FileConsumer(topic,outputfilepath);

        msgbroker.close();





    }
}

