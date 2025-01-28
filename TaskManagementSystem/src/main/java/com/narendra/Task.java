package com.narendra;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private final String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private User assignee;
    private final User reporter;

    public Task(String title, String description, LocalDate dueDate, TaskPriority taskPriority, User reporter) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.taskPriority = taskPriority;
        this.reporter = reporter;
        this.id = UUID.randomUUID().toString();
        this.taskStatus = TaskStatus.TODO;
    }

    public String getId() {
        return id;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getReporter() {
        return reporter;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", taskStatus=" + taskStatus +
                ", assignee=" + assignee +
                '}';
    }
}
