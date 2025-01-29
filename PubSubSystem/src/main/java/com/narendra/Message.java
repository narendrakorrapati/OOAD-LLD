package com.narendra;

import java.time.LocalDateTime;

public class Message {
    private final String content;
    private final LocalDateTime timeStamp;

    public Message(String content) {
        this.content = content;
        this.timeStamp = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
