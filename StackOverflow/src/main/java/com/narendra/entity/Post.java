package com.narendra.entity;

import java.time.LocalDateTime;

public abstract class Post {
    private String text;
    private final User author;
    private final LocalDateTime timeStamp;

    public Post(String text, User author) {
        this.text = text;
        this.author = author;
        this.timeStamp = LocalDateTime.now();
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

}
