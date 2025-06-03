package org.example;

public class UserValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;

    public boolean validateUser(String name, int age, String email) {
        // Validate name
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name is missing");
            return false;
        }
        if (name.length() < MIN_NAME_LENGTH) {
            System.out.println("Error: Name too short");
            return false;
        }

        // Validate age
        if (age < MIN_AGE || age > MAX_AGE) {
            System.out.println("Error: Age is out of range");
            return false;
        }

        // Validate email
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            System.out.println("Error: Email is invalid");
            return false;
        }

        return true;
    }
}