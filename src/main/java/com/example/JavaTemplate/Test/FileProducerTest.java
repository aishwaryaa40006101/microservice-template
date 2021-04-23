package com.example.JavaTemplate.Test;

import com.msgs.kafka.Imessagebroker;
import com.msgs.kafka.KafkaBroker;

import java.io.File;

public class FileProducerTest {


    public static void main(String[] args) throws Exception
    {

        PropertiesCache properties1 = PropertiesCache.getInstance();


        String server=properties1.getProperty("Kafka-Broker-url");
        String topic=properties1.getProperty("topicName");  // file publishing topicname
        String key= properties1.getProperty("key");
        String inputfilepath=properties1.getProperty("FileInputDirectory");
        String filetopic=properties1.getProperty("fileTopic");   //string publishing topic name
        System.out.println("kafka producer");

        //creating broker object
        Imessagebroker msgbroker=new KafkaBroker(server);

        //connecting to broker

        msgbroker.Connect();

        boolean brokerconnection= msgbroker.isConnected();

        System.out.println("Is broker connected:"+brokerconnection);

        try {
            File file=new File(inputfilepath);
            if(file.isFile())
            {   properties1.setProperty("FileName",file.getName());
                msgbroker.Publish(filetopic, key, file.getName());
                msgbroker.FileProducer(file, key, topic);

            }
        }
        catch(Exception exc)
        {
            System.out.println("unable to send file"+exc);
        }



        //closing connection
        msgbroker.close();


    }
}
