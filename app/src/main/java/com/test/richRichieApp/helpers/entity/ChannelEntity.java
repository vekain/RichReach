package com.test.richRichieApp.helpers.entity;

public class ChannelEntity {

    String channelId, channelName;

    public ChannelEntity(String channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public ChannelEntity(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
