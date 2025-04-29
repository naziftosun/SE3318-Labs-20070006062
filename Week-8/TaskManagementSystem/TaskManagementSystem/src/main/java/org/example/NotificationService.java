package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    private Map<User, List<String>> userNotifications;

    /**
     * Creates a new NotificationService.
     * requires: Nothing.
     * effects: Initializes the notification service.
     */
    public NotificationService(){
        this.userNotifications = new HashMap<>();
    }

    /**
     * Sends a notification message for a specific user.
     * This implementation prints to console.
     * requires: User is not null, message is not null.
     * effects: Prints the notification message to output.
     *
     */
    public void sendNotification(User user,String message){
        if (user == null || message == null){
            System.err.println("Cannot send notification because of null.");
            return;
        }
        System.out.println("Sending notification to"+user.getUserName()+ ":" + message);

        userNotifications.computeIfAbsent(user, k-> new ArrayList<>()).add(message);
    }

    /**
     * Get the list of notification messages for a specific user.
     * requires: User is not null.
     * effects: Returns a list containing all messages for the user.
     */
    public List<String> getNotifications(User user){
        if(user == null){
            return new ArrayList<>();
        }
        return new ArrayList<>(userNotifications.getOrDefault(user,new ArrayList<>()));
    }

}
