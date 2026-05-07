package com.lld.atm.states;

import com.lld.atm.ATMMachine;
import com.lld.atm.models.Card;

public class WithdrawState implements ATMState {
    @Override public void insertCard(ATMMachine atm, Card card) { System.out.println("Card already present"); }
    @Override public void authenticatePin(ATMMachine atm, int pin) { System.out.println("Already authenticated"); }
    @Override public void selectOperation(ATMMachine atm, String op) { System.out.println("Already selected"); }

    @Override
    public void withdrawCash(ATMMachine atm, int amount) {
        if (atm.getCard().getBalance() >= amount) {
            System.out.println("Withdrawing amount: " + amount);
            atm.getCard().deductBalance(amount);
            System.out.println("Remaining Balance: " + atm.getCard().getBalance());
        } else {
            System.out.println("Insufficient Balance");
        }
        ejectCard(atm);
    }

    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card Ejected");
        atm.setCard(null);
        atm.setCurrentState(new IdleState());
    }
}
