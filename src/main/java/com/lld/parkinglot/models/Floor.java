package com.lld.parkinglot.models;

import java.util.List;

public class Floor {
    int floorNumber;
    List<ParkingSpot> parkingSpots;

    public Floor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = spots;
    }

    public ParkingSpot getAvailableSpot(Vehicle v) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.canFitVehicle(v)) {
                return spot;
            }
        }
        return null;
    }
}
