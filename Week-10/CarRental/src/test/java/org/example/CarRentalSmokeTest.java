package org.example;

import org.example.model.EconomyVehicle;
import org.example.model.LuxuryVehicle;
import org.example.model.RentalRecord;
import org.example.model.VehicleAbstract;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CarRentalSmokeTest {

    @Test
    public void testVehiclePricing() {
        EconomyVehicle economyVehicle = new EconomyVehicle("Toyota", "Corolla", "ECO123", true);
        assertEquals(60.0, economyVehicle.calculateDailyRentalPrice(), 
            "Daily rate for hybrid economy car should be 60.0.");

        LuxuryVehicle luxuryVehicle = new LuxuryVehicle("BMW", "750i", "LUX123", true, true);
        assertEquals(150.0, luxuryVehicle.calculateDailyRentalPrice(), 
            "Daily rate for luxury car with GPS and leather seats should be 150.0.");

    }

    @Test
    public void testRentalCalculation() {
        VehicleAbstract vehicle = new EconomyVehicle("Honda", "Civic", "ECO789", false);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(2);
        
        RentalRecord rental = new RentalRecord("Ferrari", vehicle, startDate, endDate);
        
        assertEquals(150.0, rental.calculateTotalCost(), 
            "Total cost for 3 days of standard economy car should be 150.0.");

    }


} 