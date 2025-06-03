package org.example;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create instances of our services
        OrderProcessor orderProcessor = new OrderProcessor();
        UserValidator userValidator = new UserValidator();
        PaymentService paymentService = new PaymentService();

        // Test valid order processing
        System.out.println("\n=== Testing Valid Order ===");
        List<String> validItems = Arrays.asList("item1", "item2", "item3");
        boolean orderResult = orderProcessor.processOrder("ORD123", validItems);
        System.out.println("Order processing result: " + orderResult);

        // Test invalid order processing
        System.out.println("\n=== Testing Invalid Order ===");
        List<String> invalidItems = Arrays.asList("invalid", "item2", null);
        orderResult = orderProcessor.processOrder("", invalidItems);
        System.out.println("Invalid order processing result: " + orderResult);

        // Test user validation
        System.out.println("\n=== Testing User Validation ===");
        boolean userResult = userValidator.validateUser("John", 25, "john@example.com");
        System.out.println("Valid user validation result: " + userResult);

        userResult = userValidator.validateUser("J", 200, "invalid-email");
        System.out.println("Invalid user validation result: " + userResult);

        // Test payment processing
        System.out.println("\n=== Testing Payment Processing ===");
        boolean paymentResult = paymentService.processPayment("4111111111111111", 100.0, "USD");
        System.out.println("Valid payment processing result: " + paymentResult);

        paymentResult = paymentService.processPayment("123", -50.0, "");
        System.out.println("Invalid payment processing result: " + paymentResult);
    }
} 