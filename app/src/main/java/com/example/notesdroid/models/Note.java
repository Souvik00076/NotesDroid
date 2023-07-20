package com.example.notesdroid.models;

public class Note {
    private String description;
    private long timeStamp;
    public Note(String description,long timeStamp) {
        this.description = description;
        this.timeStamp=timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
