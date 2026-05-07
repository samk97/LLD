package com.lld.parkinglot;

import com.lld.parkinglot.models.Vehicle;
import com.lld.parkinglot.models.Car;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final List<Vehicle> parkedVehicles = new ArrayList<>();

    public void park(Vehicle vehicle) {
        System.out.println("Parking vehicle: " + vehicle.getLicensePlate());
        parkedVehicles.add(vehicle);
    }

    public static void main(String[] args) {
        com.lld.common.FileIO.setup();
        ParkingLot lot = new ParkingLot();
        lot.park(new Car("ABC-123"));
        System.out.println("Vehicles parked: " + lot.parkedVehicles.size());
    }
}
