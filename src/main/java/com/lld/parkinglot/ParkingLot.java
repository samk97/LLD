package com.lld.parkinglot;

import com.lld.parkinglot.models.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Vehicle> parkedVehicles = new ArrayList<>();

    public void park(Vehicle vehicle) {
        System.out.println("Parking vehicle: " + vehicle.getLicensePlate());
        parkedVehicles.add(vehicle);
    }

    public void displayStatus() {
        System.out.println("Current vehicles in parking lot: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        lot.park(new com.lld.parkinglot.models.Car("ABC-123"));
        lot.displayStatus();
    }
}
