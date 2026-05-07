package com.lld.atm.models;

public class Card {
    private int pin;
    private double balance;

    public Card(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}
