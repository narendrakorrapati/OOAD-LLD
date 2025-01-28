package com.narendra;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reminder {
    private final String id;
    private final User user;
    private final Task task;
    private LocalDateTime timeToRemind;

    public Reminder(User user, Task task, LocalDateTime timeToRemind) {
        this.user = user;
        this.task = task;
        this.timeToRemind = timeToRemind;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Task getTask() {
        return task;
    }

    public LocalDateTime getTimeToRemind() {
        return timeToRemind;
    }

    public void setTimeToRemind(LocalDateTime timeToRemind) {
        this.timeToRemind = timeToRemind;
    }
}
