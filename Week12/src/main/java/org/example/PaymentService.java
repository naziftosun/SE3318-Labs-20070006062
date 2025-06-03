package org.example;

public class PaymentService {
    private static final int VALID_CARD_LENGTH = 16;
    private static final String VISA_PREFIX = "4";
    private static final String USD_CURRENCY = "USD";

    public boolean processPayment(String cardNumber, double amount, String currency) {
        // Validate card number
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            System.out.println("Error: Card number is missing");
            return false;
        }
        if (cardNumber.length() != VALID_CARD_LENGTH) {
            System.out.println("Error: Invalid card number length");
            return false;
        }

        // Validate amount
        if (amount <= 0) {
            System.out.println("Error: Amount must be positive");
            return false;
        }

        // Validate currency
        if (currency == null || currency.trim().isEmpty()) {
            System.out.println("Error: Currency is missing");
            return false;
        }

        // Process payment based on card type and currency
        if (cardNumber.startsWith(VISA_PREFIX)) {
            if (currency.equals(USD_CURRENCY)) {
                System.out.println("Processing Visa USD payment");
            } else {
                System.out.println("Processing Visa payment in " + currency);
            }
        } else {
            System.out.println("Processing non-Visa card payment");
        }

        return true;
    }
}
