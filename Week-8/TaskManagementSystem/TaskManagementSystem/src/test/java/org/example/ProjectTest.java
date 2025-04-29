package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

class ProjectTest {

    private Project testProject;
    private User user1;
    private User user2;
    private Task task1;
    private Task task2;


    @BeforeEach
    void setUp() {
        testProject = new Project("Example Project");
        user1 = new User("userOne", "bir@example.com");
        user2 = new User("userTwo", "iki@example.com");
        task1 = new Task("Setup Environment", LocalDate.now().plusDays(5));
        task2 = new Task("Writing Code", LocalDate.now().plusDays(10));
    }

    @Test
    void projectCreationTest() {

        assertEquals("Example Project", testProject.getProjectName());
        assertTrue(testProject.getUsers().isEmpty());
        assertTrue(testProject.getTasks().isEmpty());

    }

    @Test
    void addUserTest() {

        testProject.addUser(user1);
        assertEquals(1, testProject.getUsers().size());
        assertTrue(testProject.getUsers().contains(user1));

        testProject.addUser(user1);
        assertEquals(1, testProject.getUsers().size());
        testProject.addUser(null);
        assertEquals(1, testProject.getUsers().size());


    }


    @Test
    void addTaskTest() {

        testProject.addTask(task1);
        assertEquals(1, testProject.getTasks().size());
        assertTrue(testProject.getTasks().contains(task1));

        testProject.addTask(task1);
        assertEquals(1, testProject.getTasks().size());
        testProject.addTask(null);
        assertEquals(1, testProject.getTasks().size());
    }

    @Test
    void getTaskByTitleTest() {

        testProject.addTask(task1);
        testProject.addTask(task2);
        Task foundTask1 = testProject.getTaskByTitle("Setup Environment");
        assertEquals(task1, foundTask1);

        Task foundTask2 = testProject.getTaskByTitle("writing code");
        assertEquals(task2, foundTask2);

        Task notFoundTask = testProject.getTaskByTitle("NonExistent Task");
        assertNull(notFoundTask);

    }
}
