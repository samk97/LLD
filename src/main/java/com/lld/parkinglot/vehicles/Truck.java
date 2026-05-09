package com.lld.parkinglot.vehicles;

import com.lld.parkinglot.enums.VehicleType;
import com.lld.parkinglot.models.Vehicle;

public class Truck extends Vehicle {
    public Truck(String number) {
        super(number, VehicleType.TRUCK);
    }
}
