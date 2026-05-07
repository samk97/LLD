package com.lld.atm.states;

import com.lld.atm.ATMMachine;
import com.lld.atm.models.Card;

public interface ATMState {
    void insertCard(ATMMachine atm, Card card);
    void authenticatePin(ATMMachine atm, int pin);
    void selectOperation(ATMMachine atm, String operation);
    void withdrawCash(ATMMachine atm, int amount);
    void ejectCard(ATMMachine atm);
}
