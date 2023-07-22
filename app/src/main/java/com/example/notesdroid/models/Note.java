package com.example.notesdroid.models;

import java.io.Serializable;

public class Note implements Serializable {
    private String description;
    private long timeStamp;
    private String id;

    public Note(String description, String id) {
        this.id = id;
        this.description = description;
        this.timeStamp = System.currentTimeMillis() / 1000;
    }

    public Note() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
