package com.lld.parkinglot.pricing;

import com.lld.parkinglot.models.Ticket;
import java.time.Duration;

public class VipPricingStrategy implements PricingStategy {

    private static final double VIP_RATE_PER_HOUR = 30.0; // discounted rate for VIP

    public double calculateAmount(Ticket t) {
        long hours = Duration.between(t.entryTime, t.exitTime).toHours();
        if (hours < 1) hours = 1;
        return hours * VIP_RATE_PER_HOUR;
    }
}
