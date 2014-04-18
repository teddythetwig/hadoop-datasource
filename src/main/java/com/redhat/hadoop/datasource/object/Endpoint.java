package com.redhat.hadoop.datasource.object;

public abstract class Endpoint {

    private static String name;
    private static String id;

    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        Endpoint.name = name;
    }
    public static String getId() {
        return id;
    }
    public static void setId(String id) {
        Endpoint.id = id;
    }





}
