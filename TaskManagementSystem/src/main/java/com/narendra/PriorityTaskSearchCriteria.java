package com.narendra;

public class PriorityTaskSearchCriteria implements TaskSearchCriteria{

    private final TaskPriority taskPriority;

    public PriorityTaskSearchCriteria(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public boolean matches(Task task) {
        return task.getTaskPriority() == taskPriority;
    }
}
