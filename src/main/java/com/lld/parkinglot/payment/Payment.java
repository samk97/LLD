package com.lld.parkinglot.payment;

import com.lld.parkinglot.enums.PaymentStatus;

public class Payment {
    String paymentId;
    double amount;
    PaymentStatus status;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public boolean makePayment() {
        if (amount > 0) {
            this.status = PaymentStatus.SUCCESS;
            System.out.println("Payment of Rs." + amount + " successful. ID: " + paymentId);
            return true;
        }
        this.status = PaymentStatus.FAILED;
        System.out.println("Payment failed for ID: " + paymentId);
        return false;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
