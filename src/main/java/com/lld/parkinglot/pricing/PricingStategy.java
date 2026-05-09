package com.lld.parkinglot.pricing;

import com.lld.parkinglot.models.Ticket;

public interface PricingStategy {
    double calculateAmount(Ticket t);
}
