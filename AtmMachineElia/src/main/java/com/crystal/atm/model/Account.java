package com.crystal.atm.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)

@Data
public class Account {

    /**
     * Account id
     */
    private String userId;
    private String accNumber;
    private final String iban;
    private long balance;
    private List<Card> cards;

    public Account(String userId, String accNumber, String iban, long balance, List<Card> cards) {
        this.iban = iban;
        this.accNumber = accNumber;
        this.userId = userId;
        this.balance = balance;
        this.cards = cards;
    }

    public void withdraw(long amount) {
        balance -= amount;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }
}
