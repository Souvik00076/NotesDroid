package com.example.notesdroid.models;

public class Note {
    private static long id=0;
    private String description, time;
    private final long noteId;
    public Note(String description, String time) {
        this.description = description;
        this.time = time;
        noteId=id++;
    }
    public long getNoteId() {
        return noteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
