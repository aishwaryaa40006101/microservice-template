package com.example.JavaTemplate.Test;

import com.msgs.kafka.Imessagebroker;
import com.msgs.kafka.KafkaBroker;

public class ConsumerTest
{
    public static void main(String[] args) throws InterruptedException {



        String TOPIC_NAME="kafkatest";

        //String topic1="demo-new";
        //String topic2="demo-b";

        System.out.println("kafka consumer");

        Imessagebroker msgbroker =(Imessagebroker) new KafkaBroker("localhost:9092");



        System.out.println("Subscribed to topic:"+TOPIC_NAME);


        msgbroker.Subscribe(TOPIC_NAME);

        msgbroker.close();



    } }


