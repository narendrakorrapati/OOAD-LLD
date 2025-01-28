package com.narendra;

import java.time.LocalDate;
import java.util.List;

public class TaskManagementSimulator {

    public static void main(String[] args) {
        TaskController taskController = new TaskController();

        User user1 = new User("narendra", "narendra@email.com");
        User user2 = new User("narendra123", "narendra123@email.com");
        Task task = new Task("Learn Java", "Learn java 8 features", LocalDate.now(), TaskPriority.HIGH, user1);
        taskController.create(task);
        List<Task> highPriorityTasks = taskController.search(new PriorityTaskSearchCriteria(TaskPriority.HIGH));
        taskController.assign(highPriorityTasks.get(0), user2);

        highPriorityTasks.get(0).setTaskStatus(TaskStatus.COMPLETED);

        taskController.update(highPriorityTasks.get(0));

        List<Task> history = taskController.getHistoryForAssignee(user2);
        System.out.println(history);
    }
}
