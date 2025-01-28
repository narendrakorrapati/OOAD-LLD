package com.narendra;

import java.time.LocalDate;

public class DueDateTaskSearchCriteria implements TaskSearchCriteria{

    private final LocalDate dueDate;
    private final DueDateComparisonOperator comparisonOperator;

    public DueDateTaskSearchCriteria(LocalDate dueDate, DueDateComparisonOperator comparisonOperator) {
        this.dueDate = dueDate;
        this.comparisonOperator = comparisonOperator;
    }

    @Override
    public boolean matches(Task task) {
        return switch (comparisonOperator) {
            case EQUALS -> task.getDueDate().equals(dueDate);
            case LESS_THAN -> task.getDueDate().isBefore(dueDate);
            case GREATER_THAN -> task.getDueDate().isAfter(dueDate);
        };
    }
}
