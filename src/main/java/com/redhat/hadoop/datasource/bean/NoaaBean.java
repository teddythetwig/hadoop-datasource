package com.redhat.hadoop.datasource.bean;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.dataset.DataSet;


public class NoaaBean{

    @EndpointInject(uri="direct:start")
    ProducerTemplate producer;


    public void execute() {
        System.out.println("Timer event recieved!!");
        producer.sendBody("<hello>world!</hello>");
    }

    public String getLocationData(Location location, DataSet dataset) {

    }

}
