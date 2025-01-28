package com.narendra;

import java.util.*;

public class TaskService {
    private final Map<String, Task> tasks;

    public TaskService() {
        this.tasks = new HashMap<>();
    }

    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    public void update(Task task) {
        Task existingTask = tasks.get(task.getId());
        if(existingTask != null) {
            existingTask.setTaskPriority(task.getTaskPriority());
            existingTask.setTaskStatus(task.getTaskStatus());
            existingTask.setAssignee(task.getAssignee());
            existingTask.setDescription(task.getDescription());
            existingTask.setTitle(task.getTitle());
        }
    }

    public void delete(String taskId) {
        tasks.remove(taskId);
    }

    public void assign(Task task, User assignee) {
        Task existingTask = tasks.get(task.getId());
        existingTask.setAssignee(assignee);
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public List<Task> getHistoryForAssignee(User assignee) {
        List<Task> history = new ArrayList<>();

        for(Task task : tasks.values()) {
            if(task.getAssignee().equals(assignee)) {
                history.add(task);
            }
        }

        return history;
    }
}
