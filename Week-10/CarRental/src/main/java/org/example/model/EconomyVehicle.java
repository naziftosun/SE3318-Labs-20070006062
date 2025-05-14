package org.example.model;

public class EconomyVehicle extends VehicleAbstract {
    private static final double BASE_PRICE = 50.0;
    private static final double HYBRID_PRICE = 10.0;

    private final boolean isHybrid;

    /**
     * Constructor for EconomyVehicle.
     *
     */

    public EconomyVehicle(String brand, String model, String licensePlate, boolean isHybrid){

        super(brand, model, licensePlate, BASE_PRICE);
        this.isHybrid = isHybrid;

    }

    /**
     * Calculate the total rental price.
     *
     * @return The total rental price.
     */
    @Override
    public double calculateDailyRentalPrice() {

        return isHybrid ? getBasePrice() + HYBRID_PRICE : getBasePrice();

    }


    /**
     * Check if the vehicle is hybrid.
     *
     * @return true if the vehicle is a hybrid, false otherwise
     */
    public boolean isHybrid() {

        return isHybrid;
    }
} 