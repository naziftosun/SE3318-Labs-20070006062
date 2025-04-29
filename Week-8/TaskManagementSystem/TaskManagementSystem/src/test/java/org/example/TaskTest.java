package org.example;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class TaskTest {

    @Test
    void testTaskCreationAndGetters() {
        String title = "Complete Lab-8";

        LocalDate dueDate = LocalDate.now().plusDays(3);
        Task task = new Task(title, dueDate);
        assertEquals(title, task.getTitle(), "Task title should match.");
        assertEquals(dueDate, task.getDueDate(), "Task due date should match.");
        assertFalse(task.isCompleted(), "New task should be marked not completed");
    }

    @Test
    void testMarkAsCompleted() {
        Task task = new Task("Test Completion", LocalDate.now().plusDays(1));
        assertFalse(task.isCompleted(), " Task should not be completed.");
        task.markedAsCompleted();
        assertTrue(task.isCompleted(), " Task should be marked completed because we called markedAsCompleted");
    }



}
