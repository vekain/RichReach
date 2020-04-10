package com.test.richRichieApp.helpers.entity;

public class ChatEntity {

    String userName, action, dateTime, location;

    public ChatEntity(String userName, String action, String dateTime, String location) {
        this.userName = userName;
        this.action = action;
        this.dateTime = dateTime;
        this.location = location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
