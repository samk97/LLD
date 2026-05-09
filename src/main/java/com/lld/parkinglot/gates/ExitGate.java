package com.lld.parkinglot.gates;

import com.lld.parkinglot.ParkingLot;
import com.lld.parkinglot.models.Ticket;
import com.lld.parkinglot.payment.Payment;
import com.lld.parkinglot.pricing.PricingStategy;

public class ExitGate extends Gate {

    ParkingLot parkingLot;
    PricingStategy pricingStrategy;

    public ExitGate(String gateId, ParkingLot parkingLot, PricingStategy pricingStrategy) {
        this.gateId = gateId;
        this.parkingLot = parkingLot;
        this.pricingStrategy = pricingStrategy;
    }

    public double scanTicket(Ticket t) {
        t.closeTicket();
        double amount = pricingStrategy.calculateAmount(t);
        Payment payment = new Payment(t.ticketId, amount);
        payment.makePayment();
        parkingLot.unparkVehicle(t);
        return amount;
    }
}
