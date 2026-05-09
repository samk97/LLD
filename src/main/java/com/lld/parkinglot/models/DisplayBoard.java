package com.lld.parkinglot.models;

import com.lld.parkinglot.enums.SpotType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    Map<SpotType, Integer> freeSpot;
    List<Floor> floors;

    public DisplayBoard(List<Floor> floors) {
        this.floors = floors;
        this.freeSpot = new HashMap<>();
        for (SpotType type : SpotType.values()) {
            freeSpot.put(type, 0);
        }
    }

    public void updateCount() {
        for (SpotType type : SpotType.values()) {
            freeSpot.put(type, 0);
        }
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.parkingSpots) {
                if (spot.isAvailable()) {
                    freeSpot.put(spot.type, freeSpot.get(spot.type) + 1);
                }
            }
        }
    }

    public void showAvailableSpots() {
        System.out.println("---- Available Parking Spots ----");
        for (Map.Entry<SpotType, Integer> entry : freeSpot.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " spots free");
        }
        System.out.println("---------------------------------");
    }
}
