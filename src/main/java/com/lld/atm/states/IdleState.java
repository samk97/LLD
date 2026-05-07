package com.lld.atm.states;

import com.lld.atm.ATMMachine;
import com.lld.atm.models.Card;

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATMMachine atm, Card card) {
        System.out.println("Card Inserted");
        atm.setCard(card);
        atm.setCurrentState(new HasCardState());
    }

    @Override public void authenticatePin(ATMMachine atm, int pin) { System.out.println("Insert card first"); }
    @Override public void selectOperation(ATMMachine atm, String op) { System.out.println("Insert card first"); }
    @Override public void withdrawCash(ATMMachine atm, int amt) { System.out.println("Insert card first"); }
    @Override public void ejectCard(ATMMachine atm) { System.out.println("No card to eject"); }
}
