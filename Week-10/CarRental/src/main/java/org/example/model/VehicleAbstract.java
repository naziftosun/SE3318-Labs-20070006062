package org.example.model;

public abstract class VehicleAbstract {
    private final String brand;
    private final String model;
    private final String licensePlate;

    private final double basePrice;


    /**
     * Constructor for VehicleAbstract.
     *
     * @param brand       The brand of the vehicle
     * @param model      The model of the vehicle
     * @param licensePlate The license plate of the vehicle
     * @param basePrice   The base rental price per day
     */
    protected VehicleAbstract(String brand, String model, String licensePlate, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.basePrice = basePrice;
    }

    /**
     * Calculate the total rental price.
     *
     * @return The total rental price.
     */
    public abstract double calculateDailyRentalPrice();

    /**
     * Get the brand of the vehicle.
     *
     * @return The brand name.
     */
    public String getBrand() {

        return brand;
    }

    /**
     * Get the model of the vehicle.
     *
     * @return The model name.
     */
    public String getModel() {

        return model;
    }

    /**
     * Get the license plate of vehicle.
     *
     * @return The license plate number.
     */
    public String getLicensePlate() {

        return licensePlate;
    }

    /**
     * Get the base price of the vehicle.
     *
     * @return The base price.
     */
    public double getBasePrice() {

        return basePrice;
    }
} 