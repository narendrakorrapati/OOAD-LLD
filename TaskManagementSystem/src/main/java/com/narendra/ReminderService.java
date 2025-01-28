package com.narendra;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ReminderService {
    private final Map<String, Reminder> reminders;

    public ReminderService() {
        this.reminders = new HashMap<>();
    }

    public void setReminder(User user, Task task, LocalDateTime remindMeAt) {
        Reminder reminder = new Reminder(user, task, remindMeAt);
        reminders.put(reminder.getId(), reminder);
    }

    public void removeReminderById(String remainderId) {
        reminders.remove(remainderId);
    }
}
