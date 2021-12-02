package com.business.util;

public enum ResourceType {
    VIDEO_PROJECTOR("Video Projector"),
    ROOM("Room"),
    LAPTOP("Laptop"),
    HDMI_CABLE("HDMI cable");

    private String name;

    ResourceType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
