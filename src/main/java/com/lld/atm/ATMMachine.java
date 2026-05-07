package com.lld.atm;

import com.lld.atm.models.Card;
import com.lld.atm.states.ATMState;
import com.lld.atm.states.IdleState;

public class ATMMachine {
    private ATMState currentState;
    private Card card;

    public ATMMachine() {
        this.currentState = new IdleState();
    }

    public void setCurrentState(ATMState state) {
        this.currentState = state;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void insertCard(Card card) { currentState.insertCard(this, card); }
    public void authenticatePin(int pin) { currentState.authenticatePin(this, pin); }
    public void selectOperation(String op) { currentState.selectOperation(this, op); }
    public void withdrawCash(int amount) { currentState.withdrawCash(this, amount); }
    public void ejectCard() { currentState.ejectCard(this); }

    public static void main(String[] args) {
        com.lld.common.FileIO.setup();
        ATMMachine atm = new ATMMachine();
        Card myCard = new Card(1234, 1000.0);

        System.out.println("--- Starting ATM Transaction ---");
        atm.insertCard(myCard);
        atm.authenticatePin(1234);
        atm.selectOperation("WITHDRAW");
        atm.withdrawCash(500);
        System.out.println("--- Transaction Finished ---");
    }
}
