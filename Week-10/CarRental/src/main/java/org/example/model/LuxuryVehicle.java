package org.example.model;


public class LuxuryVehicle extends VehicleAbstract {
    private static final double BASE_PRICE = 100.0;
    private static final double GPS_PRICE = 20.0;
    private static final double LEATHER_SEATS_PRICE = 30.0;

    private final boolean hasGPS;
    private final boolean hasLeatherSeats;

    /**
     * Constructor for LuxuryVehicle.
     *
     * @param brand          The brand of the vehicle
     * @param model         The model of the vehicle
     * @param licensePlate  The license plate of the vehicle
     * @param hasGPS        Whether the vehicle has GPS
     * @param hasLeatherSeats Whether the vehicle has leather seats
     */
    public LuxuryVehicle(String brand, String model, String licensePlate,
                        boolean hasGPS, boolean hasLeatherSeats) {
        super(brand, model, licensePlate, BASE_PRICE);
        this.hasGPS = hasGPS;
        this.hasLeatherSeats = hasLeatherSeats;


    }

    /**
     * Calculate the total rental price.
     *
     * @return The total rental price.
     */
    @Override
    public double calculateDailyRentalPrice() {
        double totalPrice = getBasePrice();
        if (hasGPS) {
            totalPrice += GPS_PRICE;
        }
        if (hasLeatherSeats) {
            totalPrice += LEATHER_SEATS_PRICE;
        }
        return totalPrice;

    }

    /**
     * Check if the vehicle has gps.
     *
     * @return true if the vehicle has gps.
     */
    public boolean hasGPS() {

        return hasGPS;

    }

    /**
     * Check if the vehicle has leather seats.
     *
     * @return true if the vehicle has leather seats.
     */
    public boolean hasLeatherSeats() {

        return hasLeatherSeats;

    }

} 