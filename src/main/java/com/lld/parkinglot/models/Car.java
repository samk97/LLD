package com.lld.parkinglot.models;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, com.lld.parkinglot.enums.VehicleType.CAR);
    }
}
