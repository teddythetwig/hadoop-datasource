package com.redhat.hadoop.datasource.object;

import java.net.URISyntaxException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class NoaaClient {

    private static NoaaClient instance = null;
    private static final String baseURL = "http://www.ncdc.noaa.gov/cdo-web/api/v2/";
    private static final String token = "hokbYLbkSJNUJeAntEMjYuulSYhrhPce";


    protected NoaaClient() {
        //do nothing
    }

    public static NoaaClient getInsance() {
        if(instance == null) {
            instance = new NoaaClient();
        }
        return instance;
    }

    public CloseableHttpResponse makeQuery(String endpoint) throws URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("baseURL" + endpoint);
        request.addHeader("token",token);
        return null;

    }

}
