package com.lld.parkinglot.models;

import java.time.LocalDateTime;

public class Ticket {
    public String ticketId;
    public LocalDateTime entryTime;
    public LocalDateTime exitTime;

    Vehicle vehicle;
    ParkingSpot spot;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public ParkingSpot getParkingSpot() {
        return spot;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
    }
}
