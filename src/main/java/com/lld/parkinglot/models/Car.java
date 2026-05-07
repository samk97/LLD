package com.lld.parkinglot.models;

import com.lld.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
