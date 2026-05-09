package com.lld.parkinglot.gates;

import com.lld.parkinglot.ParkingLot;
import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.models.Vehicle;

public class EntryGate extends Gate {

    ParkingLot parkingLot;

    public EntryGate(String gateId, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Vehicle v) {
        return parkingLot.parkVehicle(v);
    }
}
