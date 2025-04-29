package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class NotificationServiceTest {

    private NotificationService notificationService;
    private User user1;
    private User user2;
    @BeforeEach
    void setUp() {
        notificationService = new NotificationService();
        user1 = new User("User1", "1@gmail.com");
        user2 = new User("User2", "2@gmail.com");

    }


    @Test
    void sendAndGetNotificationsTest() {

        assertTrue(notificationService.getNotifications(user1).isEmpty());
        String msg1 = "First notification for user1";
        notificationService.sendNotification(user1, msg1);

        List<String> user1Notifications = notificationService.getNotifications(user1);
        assertEquals(1, user1Notifications.size());
        assertEquals(msg1, user1Notifications.get(0));

        assertTrue(notificationService.getNotifications(user2).isEmpty());
        String msg2 = "Second notification for user1";
        notificationService.sendNotification(user1, msg2);

        user1Notifications = notificationService.getNotifications(user1);
        assertEquals(2, user1Notifications.size());
        assertTrue(user1Notifications.contains(msg1));
        assertTrue(user1Notifications.contains(msg2));
    }

    @Test
    void getNotificationsForUserWithNoNotifications() {

        List<String> user2Notifications = notificationService.getNotifications(user2);
        assertNotNull(user2Notifications);
        assertTrue(user2Notifications.isEmpty());

    }


    @Test
    void sendNullNotificationTest() {
        notificationService.sendNotification(user1, null);
        assertTrue(notificationService.getNotifications(user1).isEmpty());

        notificationService.sendNotification(null, "message");


    }


}
