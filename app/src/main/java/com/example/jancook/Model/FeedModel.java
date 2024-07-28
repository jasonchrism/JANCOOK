package com.example.jancook.Model;

import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class FeedModel {

    int profileImage, duration, portion, loveCount, commentCount;
    String username, title, description, timePost;

    ArrayList<SlideModel> feedImages;

    public FeedModel(int profileImage, int duration, int portion, int loveCount, int commentCount, String username, String title, String description, String timePost, ArrayList<SlideModel> feedImages) {
        this.profileImage = profileImage;
        this.duration = duration;
        this.portion = portion;
        this.loveCount = loveCount;
        this.commentCount = commentCount;
        this.username = username;
        this.title = title;
        this.description = description;
        this.timePost = timePost;
        this.feedImages = feedImages;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(int loveCount) {
        this.loveCount = loveCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public ArrayList<SlideModel> getFeedImages() {
        return feedImages;
    }

    public void setFeedImages(ArrayList<SlideModel> feedImages) {
        this.feedImages = feedImages;
    }
}
