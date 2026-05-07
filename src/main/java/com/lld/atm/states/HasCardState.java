package com.lld.atm.states;

import com.lld.atm.ATMMachine;
import com.lld.atm.models.Card;

public class HasCardState implements ATMState {
    @Override public void insertCard(ATMMachine atm, Card card) { System.out.println("Card already present"); }

    @Override
    public void authenticatePin(ATMMachine atm, int pin) {
        if (atm.getCard().validatePin(pin)) {
            System.out.println("PIN Authenticated");
            atm.setCurrentState(new SelectionState());
        } else {
            System.out.println("Wrong PIN");
            ejectCard(atm);
        }
    }

    @Override public void selectOperation(ATMMachine atm, String op) { System.out.println("Enter PIN first"); }
    @Override public void withdrawCash(ATMMachine atm, int amt) { System.out.println("Enter PIN first"); }
    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card Ejected");
        atm.setCard(null);
        atm.setCurrentState(new IdleState());
    }
}
