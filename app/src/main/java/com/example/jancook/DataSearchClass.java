package com.example.jancook;

public class DataSearchClass {
    private String dataLocation;
    private String dataTitle;
    private String dataPost;

    public String getDataLocation() {
        return dataLocation;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataPost() {
        return dataPost;
    }

    public DataSearchClass(String dataLocation, String dataTitle, String dataPost) {
        this.dataLocation = dataLocation;
        this.dataTitle = dataTitle;
        this.dataPost = dataPost;
    }
}
