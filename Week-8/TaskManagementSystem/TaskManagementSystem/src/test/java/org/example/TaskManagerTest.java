package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

class TaskManagerTest {
    private TaskManager taskManager;
    private NotificationService notificationService;
    private User user1;
    private Task task1;
    @BeforeEach
    void setUp() {
        notificationService = new NotificationService();
        taskManager = new TaskManager(notificationService);
        user1 = new User("managerUser", "manager@gmail.com");
        task1 = new Task("Managed Task", LocalDate.now().plusDays(7));
    }

    @Test
    void assignTaskToUserTest() {
        assertTrue(user1.getAllTasks().isEmpty());
        assertTrue(notificationService.getNotifications(user1).isEmpty());
        taskManager.assignTaskToUser(task1, user1);

        assertEquals(1, user1.getAllTasks().size(), "User should have 1task after assignment. ");
        assertTrue(user1.hasTask(task1), "User should have assigned taskç");
        assertEquals(1, notificationService.getNotifications(user1).size(), "User should have 1 notification.");
        assertTrue(notificationService.getNotifications(user1).get(0).contains(task1.getTitle()), "Notification should contain task title.");

    }


    @Test
    void removeTaskFromUserTest() {

        taskManager.assignTaskToUser(task1, user1);
        assertEquals(1, user1.getAllTasks().size());
        taskManager.removeTaskFromUser(task1, user1);

        assertTrue(user1.getAllTasks().isEmpty(), "User task list should be empty.");
        assertFalse(user1.hasTask(task1), "User should not have the task.");
        assertEquals(1, notificationService.getNotifications(user1).size());
    }

    @Test
    void listTasksForUserTest() {
        List<Task> tasks = taskManager.listTasksForUser(user1);
        assertNotNull(tasks);
        assertTrue(tasks.isEmpty());

        taskManager.assignTaskToUser(task1, user1);
        tasks = taskManager.listTasksForUser(user1);
        assertEquals(1, tasks.size());
        assertEquals(task1, tasks.get(0));
    }


    @Test
    void assignNullTaskOrUserTest() {
        taskManager.assignTaskToUser(null, user1);
        assertTrue(user1.getAllTasks().isEmpty(), " User tasks should be empty.");
        assertTrue(notificationService.getNotifications(user1).isEmpty(), "User notifications should be empty.");

        taskManager.assignTaskToUser(task1, null);

    }

    @Test
    void removeNullTaskOrUserTest() {

        taskManager.assignTaskToUser(task1, user1);
        assertEquals(1, user1.getAllTasks().size());
        taskManager.removeTaskFromUser(null, user1);
        assertEquals(1, user1.getAllTasks().size(), "User tasks should not change. ");

        taskManager.removeTaskFromUser(task1, null);
        assertEquals(1, user1.getAllTasks().size());

    }


    @Test
    void listTasksForNullUserTest() {

        List<Task> tasks = taskManager.listTasksForUser(null);
        assertNotNull(tasks);
        assertTrue(tasks.isEmpty(), "Should return empty list.");

    }

}
