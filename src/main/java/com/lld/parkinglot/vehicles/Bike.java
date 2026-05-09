package com.lld.parkinglot.vehicles;

import com.lld.parkinglot.enums.VehicleType;
import com.lld.parkinglot.models.Vehicle;

public class Bike extends Vehicle {
    public Bike(String number) {
        super(number, VehicleType.BIKE);
    }
}
