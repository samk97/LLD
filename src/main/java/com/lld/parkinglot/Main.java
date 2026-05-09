package com.lld.parkinglot;

import com.lld.parkinglot.enums.SpotType;
import com.lld.parkinglot.enums.VehicleType;
import com.lld.parkinglot.gates.EntryGate;
import com.lld.parkinglot.gates.ExitGate;
import com.lld.parkinglot.models.Floor;
import com.lld.parkinglot.models.ParkingSpot;
import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.models.Vehicle;
import com.lld.parkinglot.pricing.HourlyPricingStrategy;
import com.lld.parkinglot.pricing.PricingStategy;
import com.lld.parkinglot.vehicles.VehicleFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Setup Floors and Spots ---
        List<ParkingSpot> floor1Spots = new ArrayList<>(Arrays.asList(
            new ParkingSpot("S1", SpotType.SMALL),
            new ParkingSpot("S2", SpotType.SMALL),
            new ParkingSpot("M1", SpotType.MEDIUM),
            new ParkingSpot("M2", SpotType.MEDIUM),
            new ParkingSpot("L1", SpotType.LARGE),
            new ParkingSpot("E1", SpotType.EV)
        ));

        List<ParkingSpot> floor2Spots = new ArrayList<>(Arrays.asList(
            new ParkingSpot("S3", SpotType.SMALL),
            new ParkingSpot("M3", SpotType.MEDIUM),
            new ParkingSpot("L2", SpotType.LARGE)
        ));

        Floor floor1 = new Floor(1, floor1Spots);
        Floor floor2 = new Floor(2, floor2Spots);
        List<Floor> floors = new ArrayList<>(Arrays.asList(floor1, floor2));

        // --- Setup ParkingLot ---
        ParkingLot parkingLot = new ParkingLot(
            "City Mall Parking",
            "123 Main Street",
            floors,
            new ArrayList<>(),
            new ArrayList<>()
        );

        // --- Setup Gates with pricing strategy ---
        PricingStategy hourlyPricing = new HourlyPricingStrategy();
        EntryGate entryGate = new EntryGate("ENTRY-1", parkingLot);
        ExitGate exitGate = new ExitGate("EXIT-1", parkingLot, hourlyPricing);

        // --- Show initial board ---
        System.out.println("=== City Mall Parking ===");
        parkingLot.displayBoard.updateCount();
        parkingLot.displayBoard.showAvailableSpots();

        // --- Park vehicles ---
        Vehicle bike = VehicleFactory.createVehicle(VehicleType.BIKE, "KA-01-1234");
        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "KA-02-5678");
        Vehicle truck = VehicleFactory.createVehicle(VehicleType.TRUCK, "KA-03-9999");

        System.out.println("\n-- Parking Bike --");
        Ticket bikeTicket = entryGate.generateTicket(bike);
        if (bikeTicket != null) System.out.println("Ticket issued: " + bikeTicket.ticketId);

        System.out.println("\n-- Parking Car --");
        Ticket carTicket = entryGate.generateTicket(car);
        if (carTicket != null) System.out.println("Ticket issued: " + carTicket.ticketId);

        System.out.println("\n-- Parking Truck --");
        Ticket truckTicket = entryGate.generateTicket(truck);
        if (truckTicket != null) System.out.println("Ticket issued: " + truckTicket.ticketId);

        // --- Show board after parking ---
        System.out.println("\n-- Board after parking --");
        parkingLot.displayBoard.showAvailableSpots();

        // --- Exit bike ---
        System.out.println("\n-- Bike Exiting --");
        if (bikeTicket != null) {
            double amount = exitGate.scanTicket(bikeTicket);
            System.out.println("Total charged: Rs." + amount);
        }

        // --- Show board after exit ---
        System.out.println("\n-- Board after bike exit --");
        parkingLot.displayBoard.showAvailableSpots();
    }
}
