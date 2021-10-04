package com.example;

import javax.servlet.http.HttpServletRequest;

public class RequestType {
    private boolean mock;
    private int value;
    private String key;
    private boolean sync;

    public RequestType(HttpServletRequest request){
        this.mock = Boolean.parseBoolean(request.getParameter("mock"));
        this.value = Integer.parseInt(request.getParameter("value"));
        this.key = request.getParameter("key");
        this.sync = Boolean.parseBoolean(request.getParameter("sync"));
    }

    public boolean isMock() {
        return mock;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public boolean isSync() {
        return sync;
    }

    @Override
    public String toString() {
        return "{" +
                "mock=" + mock +
                ", value=" + value +
                ", key='" + key + '\'' +
                ", sync=" + sync +
                '}';
    }
}
