package com.lld.parkinglot.models;

import com.lld.parkinglot.enums.VehicleType;

public abstract class Vehicle {
    public String licenseNumber;
    public VehicleType type;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}
