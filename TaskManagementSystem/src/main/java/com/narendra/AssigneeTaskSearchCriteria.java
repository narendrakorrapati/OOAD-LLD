package com.narendra;

public class AssigneeTaskSearchCriteria implements TaskSearchCriteria{
    private final User assignee;

    public AssigneeTaskSearchCriteria(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean matches(Task task) {
        return task.getAssignee().equals(assignee);
    }
}
