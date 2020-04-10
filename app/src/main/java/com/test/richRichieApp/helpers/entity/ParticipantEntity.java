package com.test.richRichieApp.helpers.entity;

public class ParticipantEntity {

    int accessRightsImage;
    String name;

    public ParticipantEntity(int image, String name) {
        this.accessRightsImage = image;
        this.name = name;
    }

    public int getAccessRightsImage() {
        return accessRightsImage;
    }

    public void setAccessRightsImage(int accessRightsImage) {
        this.accessRightsImage = accessRightsImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
