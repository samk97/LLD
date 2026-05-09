package com.lld.parkinglot.vehicles;

import com.lld.parkinglot.enums.VehicleType;
import com.lld.parkinglot.models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String number) {
        switch (type) {
            case BIKE:
                return new Bike(number);
            case CAR:
                return new Car(number);
            case TRUCK:
                return new Truck(number);
            default:
                return null;
        }
    }
}
