package com.lld.parkinglot.pricing;

import com.lld.parkinglot.models.Ticket;
import java.time.Duration;

public class WeekendPricingStrategy implements PricingStategy {

    private static final double WEEKEND_RATE_PER_HOUR = 75.0; // higher rate on weekends

    public double calculateAmount(Ticket t) {
        long hours = Duration.between(t.entryTime, t.exitTime).toHours();
        if (hours < 1) hours = 1;
        return hours * WEEKEND_RATE_PER_HOUR;
    }
}
