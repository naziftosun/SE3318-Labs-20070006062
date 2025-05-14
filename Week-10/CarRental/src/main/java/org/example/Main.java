package org.example;

import org.example.model.EconomyVehicle;
import org.example.model.LuxuryVehicle;
import org.example.model.RentalRecord;
import org.example.model.VehicleAbstract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<VehicleAbstract> vehicles = new ArrayList<>();

        vehicles.add(new LuxuryVehicle("BMW", "750i", "LUX001", true, true));
        vehicles.add(new LuxuryVehicle("Mercedes", "S-Class", "LUX002", true, false));
        vehicles.add(new LuxuryVehicle("Audi", "A8", "LUX003", false, true));
        vehicles.add(new EconomyVehicle("Toyota", "Prius", "ECO001", true));
        vehicles.add(new EconomyVehicle("Honda", "Civic", "ECO002", false));
        vehicles.add(new EconomyVehicle("Hyundai", "Ioniq", "ECO003", true));

        System.out.println("Available Vehicles:");
        
        for (VehicleAbstract vehicle : vehicles) {
            System.out.printf("%s %s (License: %s) - Daily Rate: $%.2f%n",
                    vehicle.getBrand(),
                    vehicle.getModel(),
                    vehicle.getLicensePlate(),
                    vehicle.calculateDailyRentalPrice());

        }


        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);

        RentalRecord rental1 = new RentalRecord("CUST001", vehicles.get(0), startDate, endDate);
        RentalRecord rental2 = new RentalRecord("CUST002", vehicles.get(3), startDate, endDate);
        System.out.println("\nRental Records:");
        
        printRentalDetails(rental1);
        printRentalDetails(rental2);


    }

    private static void printRentalDetails(RentalRecord rental) {
        VehicleAbstract vehicle = rental.getVehicle();
        System.out.printf("Customer ID: %s%n", rental.getRenterId());
        System.out.printf("Vehicle: %s %s (License: %s)%n",
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getLicensePlate());

        System.out.printf("Rental Period: %s to %s%n",
                rental.getStartDate(),
                rental.getEndDate());

        System.out.printf("Daily Rate: $%.2f%n", rental.getDailyRate());
        System.out.printf("Total Cost: $%.2f%n", rental.calculateTotalCost());
        System.out.println();

    }


}