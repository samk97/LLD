package com.lld.parkinglot.pricing;

import com.lld.parkinglot.models.Ticket;
import java.time.Duration;

public class HourlyPricingStrategy implements PricingStategy {

    private static final double RATE_PER_HOUR = 50.0;

    public double calculateAmount(Ticket t) {
        long hours = Duration.between(t.entryTime, t.exitTime).toHours();
        if (hours < 1) hours = 1; // minimum 1 hour charge
        return hours * RATE_PER_HOUR;
    }
}
