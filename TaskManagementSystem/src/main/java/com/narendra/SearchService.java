package com.narendra;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    private final TaskService taskService;

    public SearchService(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> search(TaskSearchCriteria taskSearchCriteria) {
        List<Task> tasks = taskService.findAll();
        return tasks.stream().filter(taskSearchCriteria::matches).collect(Collectors.toList());
    }
}
