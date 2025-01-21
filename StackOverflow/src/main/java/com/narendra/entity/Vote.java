package com.narendra.entity;

import java.time.LocalDateTime;

public class Vote {
    private final boolean isUpvote;
    private final User author;
    private final LocalDateTime timeStamp;

    public Vote(boolean isUpvote, User author) {
        this.isUpvote = isUpvote;
        this.author = author;
        this.timeStamp = LocalDateTime.now();
    }

    public boolean isUpvote() {
        return isUpvote;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
