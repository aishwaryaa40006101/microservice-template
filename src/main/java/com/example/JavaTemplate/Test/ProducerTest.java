package com.example.JavaTemplate.Test;

import com.msgs.kafka.Imessagebroker;
import com.msgs.kafka.KafkaBroker;

public class ProducerTest
{
    public static void main(String[] args) throws InterruptedException
    {


        String key="b";
        String TOPIC_NAME="kafkatest";
        String MESSAGE="hello kafka test !";

        System.out.println("kafka producer");

        Imessagebroker msgbroker=new KafkaBroker("localhost:9092");
        msgbroker.Connect();
        boolean brokerconnection= msgbroker.isConnected();
        System.out.println("Is broker connected:"+brokerconnection);


        msgbroker.Publish(TOPIC_NAME,key,MESSAGE);
        // System.out.println(ispublished);

        msgbroker.close();


    }


}