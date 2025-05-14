package org.example.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Smoke test for the car rental system.
 */
public class CarRentalSmokeTest {

    /**
     * Test luxury vehicle creation and pricing.
     */
    @Test
    public void testLuxuryVehicle() {
        LuxuryVehicle luxuryCar = new LuxuryVehicle("BMW", "750i", "ABC123", true, true);
        
        assertEquals("BMW", luxuryCar.getBrand());
        assertEquals("750i", luxuryCar.getModel());
        assertEquals("ABC123", luxuryCar.getLicensePlate());
        assertTrue(luxuryCar.hasGPS());
        assertTrue(luxuryCar.hasLeatherSeats());
        
        // Base price (100) + GPS (20) + Leather seats (30) = 150
        assertEquals(150.0, luxuryCar.calculateDailyRentalPrice(), 0.01);
    }

    /**
     * Test economy vehicle creation and pricing.
     */
    @Test
    public void testEconomyVehicle() {
        EconomyVehicle economyCar = new EconomyVehicle("Toyota", "Prius", "XYZ789", true);
        
        assertEquals("Toyota", economyCar.getBrand());
        assertEquals("Prius", economyCar.getModel());
        assertEquals("XYZ789", economyCar.getLicensePlate());
        assertTrue(economyCar.isHybrid());
        
        // Base price (50) + Hybrid (10) = 60
        assertEquals(60.0, economyCar.calculateDailyRentalPrice(), 0.01);
    }

    /**
     * Test rental record creation and total cost calculation.
     */
    @Test
    public void testRentalRecord() {
        LuxuryVehicle luxuryCar = new LuxuryVehicle("Mercedes", "E-Class", "DEF456", true, false);
        LocalDate startDate = LocalDate.of(2024, 3, 1);
        LocalDate endDate = LocalDate.of(2024, 3, 3);
        
        RentalRecord record = new RentalRecord("CUST001", luxuryCar, startDate, endDate);
        
        assertEquals("CUST001", record.getRenterId());
        assertEquals(luxuryCar, record.getVehicle());
        assertEquals(startDate, record.getStartDate());
        assertEquals(endDate, record.getEndDate());
        
        // Daily rate: Base price (100) + GPS (20) = 120
        // Total for 3 days = 120 * 3 = 360
        assertEquals(360.0, record.calculateTotalCost(), 0.01);
    }
} 