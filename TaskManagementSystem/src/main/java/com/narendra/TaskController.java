package com.narendra;

import java.time.LocalDateTime;
import java.util.List;

public class TaskController {
    private final TaskService taskService;
    private final SearchService searchService;
    private final ReminderService reminderService;

    public TaskController() {
        this.taskService = new TaskService();
        this.searchService = new SearchService(taskService);
        this.reminderService = new ReminderService();
    }

    public List<Task> search(TaskSearchCriteria taskSearchCriteria) {
        return searchService.search(taskSearchCriteria);
    }

    public void create(Task task) {
        taskService.save(task);
    }

    public void update(Task task) {
        taskService.update(task);
    }

    public void delete(String taskId) {
        taskService.delete(taskId);
    }

    public void assign(Task task, User assignee) {
        taskService.assign(task, assignee);
    }

    public void setRemainder(User user, Task task, LocalDateTime remindMeAt) {
        reminderService.setReminder(user, task, remindMeAt);
    }

    public List<Task> getHistoryForAssignee(User user) {
        return taskService.getHistoryForAssignee(user);
    }
}
