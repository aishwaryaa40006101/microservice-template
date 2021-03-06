package com.example.JavaTemplate.Test;

import com.activemq.ActivemqBroker.ActiveMQBroker;
import com.activemq.ActivemqBroker.IMessageBroker;
import org.junit.Test;

import javax.jms.JMSException;
import java.io.File;
import java.net.URISyntaxException;

public class Test2 {
    private static PropertiesCache prop = PropertiesCache.getInstance();
    private static IMessageBroker publisher, subscriber;

    @Test
    public void testPubFileTranfer() throws JMSException, InterruptedException, URISyntaxException {
        String FileInputDirectory=prop.getProperty("FileInputDirectory");
        String brokerurl= prop.getProperty("ActiveMQ-Broker-url");
        publisher = new ActiveMQBroker(brokerurl);
        publisher.connect("Sender");
        Boolean senderConnected=publisher.isConnected();
        System.out.println(senderConnected);
        try {
            File file = new File(FileInputDirectory);
                if (file.isFile()) {
                    publisher.publish(file.getName(),"pub-sub1");
                    publisher.publishFileAsByteMessage(file,"pub-sub2");
                }
        } catch (Exception e) {
            System.out.println("unable to send file due to an error"+e);
        }
       publisher.closeConnection();
        Boolean senderConnected1=publisher.isConnected();
        System.out.println(senderConnected1);
        Thread.sleep(2000);
    }

    @Test
    public void testSubFileTranfer() throws JMSException, URISyntaxException {
        String brokerurl= prop.getProperty("ActiveMQ-Broker-url");
        String outputFilePath= prop.getProperty("FileOutPutByteDirectory");
        subscriber=new ActiveMQBroker(brokerurl);
        subscriber.connect("Receiver");
        Boolean receiverConnected=subscriber.isConnected();
        System.out.println(receiverConnected);
        subscriber.subscribe("pub-sub1");
        subscriber.subscribeFileFromBroker(outputFilePath,"pub-sub2");
        subscriber.closeConnection();
        Boolean receiverConnected1=subscriber.isConnected();
        System.out.println(receiverConnected1);
    }




}
