package com.example.jancook.Model;

public class StoryModel {
    String uid, sid, name;
    int image, type;

    public StoryModel(int type, String uid, String sid, String name, int image) {
        this.type = type;
        this.uid = uid;
        this.sid = sid;
        this.name = name;
        this.image = image;
    }

    public StoryModel(int type, String uid, int image) {
        this.uid = uid;
        this.image = image;
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
