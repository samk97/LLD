package com.lld.parkinglot;

import com.lld.parkinglot.gates.EntryGate;
import com.lld.parkinglot.gates.ExitGate;
import com.lld.parkinglot.models.DisplayBoard;
import com.lld.parkinglot.models.Floor;
import com.lld.parkinglot.models.ParkingSpot;
import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.models.Vehicle;

import java.util.List;
import java.util.UUID;

public class ParkingLot {
    String name;
    String address;

    List<Floor> floors;
    List<EntryGate> entryGates;
    List<ExitGate> exitGates;
    DisplayBoard displayBoard;

    public ParkingLot(String name, String address, List<Floor> floors,
                      List<EntryGate> entryGates, List<ExitGate> exitGates) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.displayBoard = new DisplayBoard(floors);
    }

    public Ticket parkVehicle(Vehicle v) {
        for (Floor floor : floors) {
            ParkingSpot spot = floor.getAvailableSpot(v);
            if (spot != null) {
                spot.assignVehicle(v);
                displayBoard.updateCount();
                return new Ticket(UUID.randomUUID().toString(), v, spot);
            }
        }
        System.out.println("No available spot for vehicle: " + v.licenseNumber);
        return null;
    }

    public void unparkVehicle(Ticket t) {
        t.getParkingSpot().removeVehicle();
        displayBoard.updateCount();
    }
}
