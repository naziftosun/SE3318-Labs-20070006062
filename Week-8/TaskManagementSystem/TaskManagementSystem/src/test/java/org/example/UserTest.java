package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class UserTest {
    private User user;
    private Task task1;
    private Task task2;


    @BeforeEach
    void setUp() {
        user = new User("user", "example@gmail.com");
        task1 = new Task("Task1", LocalDate.now().plusDays(1));
        task2 = new Task("Task2", LocalDate.now().plusDays(2));

    }

    @Test
    void testUserCreationAndGetters() {
        assertEquals("user", user.getUserName(), "Username should match.");
        assertEquals("example@gmail.com", user.getEmail(), "Email should match");
        assertNotNull(user.getAllTasks(), "Task list should not be null.");
        assertTrue(user.getAllTasks().isEmpty(), "Task list should be empty.");

    }

    @Test
    void testAddTask() {

        user.addTask(task1);
        assertEquals(1, user.getAllTasks().size(), "Task list should contain 1 task.");
        assertTrue(user.hasTask(task1), "User should have task1 after adding");
        assertFalse(user.hasTask(task2), "User should not have task2.");
    }

    @Test
    void testAddDuplicateTask() {
        user.addTask(task1);
        assertEquals(1, user.getAllTasks().size(), "Task list should contain 1task.");
        user.addTask(task1);
        assertEquals(1, user.getAllTasks().size(), "Task list size should remain 1.");

    }


    @Test
    void testAddNullTask() {
        user.addTask(null);
        assertTrue(user.getAllTasks().isEmpty(), "Task list should remain empty.");

    }
    @Test
    void testRemoveTask() {

        user.addTask(task1);
        user.addTask(task2);
        assertEquals(2, user.getAllTasks().size(), "Task list should contain 2 tasks.");

        user.removeTask(task1);
        assertEquals(1, user.getAllTasks().size(), "Task list should contain 1 task.");
        assertFalse(user.hasTask(task1), "User should not have task1.");
        assertTrue(user.hasTask(task2), "User should still have task2.");

        Task notExistTask = new Task("not exist", LocalDate.now());
        user.removeTask(notExistTask);

        assertEquals(1, user.getAllTasks().size(), "Task list size should not change.");

        user.removeTask(task2);
        assertTrue(user.getAllTasks().isEmpty(), "Task list should be empty.");
    }

}
