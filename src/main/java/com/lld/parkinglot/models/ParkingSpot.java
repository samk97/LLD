package com.lld.parkinglot.models;

import com.lld.parkinglot.enums.SpotType;
import com.lld.parkinglot.enums.VehicleType;

public class ParkingSpot {
    String spotId;
    SpotType type;
    boolean occupied;
    Vehicle vehicle;

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
        this.occupied = false;
    }

    public boolean canFitVehicle(Vehicle v) {
        if (v.getType() == VehicleType.BIKE && type == SpotType.SMALL) {
            return true;
        }
        if (v.getType() == VehicleType.CAR && type == SpotType.MEDIUM) {
            return true;
        }
        if (v.getType() == VehicleType.TRUCK && type == SpotType.LARGE) {
            return true;
        }
        if (v.getType() == VehicleType.CAR && type == SpotType.EV) {
            return true;
        }
        if (v.getType() == VehicleType.BIKE && type == SpotType.EV) {
            return true;
        }
        return false;
    }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public boolean isAvailable() {
        return !occupied;
    }
}
