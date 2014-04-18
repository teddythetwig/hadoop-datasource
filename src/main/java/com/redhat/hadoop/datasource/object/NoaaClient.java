package com.redhat.hadoop.datasource.object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
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

    public static NoaaClient getInstance() {
        if(instance == null) {
            instance = new NoaaClient();
        }
        return instance;
    }

    public String makeQuery(String endpoint) throws ClientProtocolException, IOException {
        System.out.println("Requesting: " +baseURL + endpoint);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntity entity= null;
        try {
            HttpGet request = new HttpGet(baseURL + endpoint);
            request.addHeader("token",token);
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                entity = response.getEntity();
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
            return constructStringFromHttpEntity(entity);

    }

    public String constructStringFromHttpEntity(HttpEntity entity){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            String line = null;

            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
