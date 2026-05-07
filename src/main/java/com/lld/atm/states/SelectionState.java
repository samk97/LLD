package com.lld.atm.states;

import com.lld.atm.ATMMachine;
import com.lld.atm.models.Card;

public class SelectionState implements ATMState {
    @Override public void insertCard(ATMMachine atm, Card card) { System.out.println("Card already present"); }
    @Override public void authenticatePin(ATMMachine atm, int pin) { System.out.println("Already authenticated"); }

    @Override
    public void selectOperation(ATMMachine atm, String operation) {
        System.out.println("Operation selected: " + operation);
        if (operation.equals("WITHDRAW")) {
            atm.setCurrentState(new WithdrawState());
        } else {
            System.out.println("Other operations not implemented");
            ejectCard(atm);
        }
    }

    @Override public void withdrawCash(ATMMachine atm, int amt) { System.out.println("Select operation first"); }
    @Override
    public void ejectCard(ATMMachine atm) {
        System.out.println("Card Ejected");
        atm.setCard(null);
        atm.setCurrentState(new IdleState());
    }
}
