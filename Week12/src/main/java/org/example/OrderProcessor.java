package org.example;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Handles the processing of customer orders in the e-commerce platform.
 * This class implements defensive programming practices to ensure robust order processing.
 */
public class OrderProcessor {
    private static final Logger LOGGER = Logger.getLogger(OrderProcessor.class.getName());
    private static final int MIN_ORDER_ID_LENGTH = 3;
    private static final String ITEM_PREFIX = "item";

    /**
     * Processes a customer order with the given order ID and list of items.
     *
     * @param orderId The unique identifier for the order
     * @param items List of items in the order
     * @return true if order was processed successfully, false otherwise
     * @throws IllegalArgumentException if orderId is null or empty, or if items list is null or empty
     */
    public boolean processOrder(String orderId, List<String> items) {
        try {
            // Validate order ID
            if (orderId == null || orderId.trim().isEmpty()) {
                LOGGER.log(Level.WARNING, "Invalid order ID: cannot be null or empty");
                throw new IllegalArgumentException("Order ID cannot be null or empty");
            }

            // Validate items list
            if (items == null || items.isEmpty()) {
                LOGGER.log(Level.WARNING, "Invalid items list for order {0}: cannot be null or empty", orderId);
                throw new IllegalArgumentException("Items list cannot be null or empty");
            }

            // Process order based on complexity
            if (orderId.length() > MIN_ORDER_ID_LENGTH) {
                LOGGER.log(Level.INFO, "Processing complex order: {0}", orderId);
            } else {
                LOGGER.log(Level.INFO, "Processing simple order: {0}", orderId);
            }

            // Process each item
            for (String item : items) {
                if (item == null || item.trim().isEmpty()) {
                    LOGGER.log(Level.WARNING, "Skipping null or empty item in order {0}", orderId);
                    continue;
                }

                if (item.toLowerCase().contains(ITEM_PREFIX)) {
                    LOGGER.log(Level.INFO, "Processing valid item: {0}", item);
                } else {
                    LOGGER.log(Level.WARNING, "Skipping invalid item format: {0}", item);
                }
            }

            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error processing order {0}: {1}", 
                new Object[]{orderId, e.getMessage()});
            return false;
        }
    }
}