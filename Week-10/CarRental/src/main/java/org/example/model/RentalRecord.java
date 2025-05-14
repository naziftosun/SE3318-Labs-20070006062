package org.example.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalRecord {
    private final String renterId;
    private final VehicleAbstract vehicle;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double dailyRate;

    /**
     * Constructor for RentalRecord.
     *
     * @param renterId   The ID of the person renting the vehicle
     * @param vehicle    The vehicle being rented
     * @param startDate  The start date of the rental
     * @param endDate    The end date of the rental
     */
    public RentalRecord(String renterId, VehicleAbstract vehicle,
                       LocalDate startDate, LocalDate endDate) {
        this.renterId = renterId;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dailyRate = vehicle.calculateDailyRentalPrice();

    }

    /**
     * Calculate the total cost of the rental.
     *
     * @return The total cost.
     */
    public double calculateTotalCost() {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return dailyRate * days;

    }

    /**
     * Get the renter's ID.
     *
     * @return The ID.
     */
    public String getRenterId() {

        return renterId;

    }

    /**
     * Get the rented vehicle.
     *
     * @return The vehicle rented.
     */
    public VehicleAbstract getVehicle() {

        return vehicle;

    }

    /**
     * Get the rental start date.
     *
     * @return The start date.
     */
    public LocalDate getStartDate() {

        return startDate;
    }

    /**
     * Get the rental end date.
     *
     * @return The end date.
     */
    public LocalDate getEndDate() {

        return endDate;
    }

    /**
     * Get the daily rental rate.
     *
     * @return The daily rental.
     */
    public double getDailyRate() {

        return dailyRate;
    }
} 