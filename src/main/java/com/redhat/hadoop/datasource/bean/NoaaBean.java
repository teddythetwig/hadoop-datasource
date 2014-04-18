package com.redhat.hadoop.datasource.bean;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;

import com.redhat.hadoop.datasource.object.NoaaClient;


public class NoaaBean{

    @EndpointInject(uri="direct:start")
    ProducerTemplate producer;


    public void execute() {
        System.out.println("Timer event recieved!!");
        NoaaClient client = NoaaClient.getInstance();
        // Perhaps register this with a callback so we can make multiple requests in parallel
        try {
            String response = client.makeQuery("locations");
            producer.sendBody(response);
        } catch(Exception e){
            e.printStackTrace();
        }

    }


}
