package com.lld.parkinglot.vehicles;

import com.lld.parkinglot.enums.VehicleType;
import com.lld.parkinglot.models.Vehicle;

public class Car extends Vehicle {
    public Car(String number) {
        super(number, VehicleType.CAR);
    }
}
