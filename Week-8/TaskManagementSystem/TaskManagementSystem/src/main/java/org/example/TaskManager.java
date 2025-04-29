package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private NotificationService notificationService;

    /**
     * Creates a new TaskManager with notificationService.
     * requires: Notification is not null.
     * effects: Initializes new TaskManage object.
     */
    public TaskManager(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    /**
     * Assign a task to user and sends a notification.
     * requires: Task is not null, user is not null.
     * effects: Adds the task to user's task list.Sends a notification about new task.
     */
    public void assignTaskToUser(Task task, User user){
        if (task != null && user != null){
            System.out.println("Assigning task "+ task.getTitle() + " to user" + user.getUserName());

            user.addTask(task);

            notificationService.sendNotification(user,"assigned new task:" + task.getTitle());
        }
    }

    /**
     * Removes a task from user.
     * requires: Task is not null, user is not null.
     * effects: Removes the task from the user's task list.
     */
    public void removeTaskFromUser(Task task, User user){
        if (task != null && user != null){
            System.out.println("Removing task" + task.getTitle() + "from user" + user.getUserName());
            user.removeTask(task);
        }
    }

    /**
     * Returns list of tasks od user.
     * requires: User is not null.
     * effects: Returns the list of tasks of user.
     */
    public List<Task> listTasksForUser(User user){
        if (user != null){
            return user.getAllTasks();
        }
        return new ArrayList<>();
    }

}
