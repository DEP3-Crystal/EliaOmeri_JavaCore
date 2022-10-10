package com.crystal.atm.service;

import com.crystal.atm.dao.DataAccess;
import com.crystal.atm.model.Account;
import com.crystal.atm.model.Card;
import com.crystal.atm.model.User;

import java.io.IOException;
import java.util.Objects;

public class AccountService {
    //1-withdraw
    //2-deposit

    private DataAccess dataAccess;

    public AccountService(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }


    public boolean withdraw(Account account, long amount) throws IllegalArgumentException {
        if (amount % 500.0 == 0.0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        } else {
            throw new IllegalArgumentException("Transaction can't be done!");

        }
    }

    public boolean deposit(Account account, long amount) {
        if (amount % 500 == 0) {
            account.deposit(amount);
            System.out.println("Transfer done!");
            return true;
        } else {
            System.out.println("Please enter the amount in multiple of 500");
            return false;
        }
    }

    public boolean isActiveCard(String cardId) throws NullPointerException {
        try {
            return dataAccess.getUsers()
                    .stream()
                    .flatMap(user -> user.getAccounts()
                            .stream()
                            .flatMap(account -> account.getCards()
                                    .stream()))
                    .anyMatch(card -> card.getIdCard().equals(cardId));
        } catch (NullPointerException ignored) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean isActiveCardPin(String cardId, String cardPin) {
        try {
            return dataAccess.getUsers()
                    .stream()
                    .flatMap(user -> user.getAccounts()
                            .stream()
                            .flatMap(account -> account.getCards()
                                    .stream()))
                    .anyMatch(card -> card.getIdCard().equals(cardId) && card.getPin().equals(cardPin));
        } catch (NullPointerException | IOException ignored) {

        }
        return false;
    }

    public Account getAccountByCardNr(String cardNumber) throws IOException {

        for (User user : dataAccess.getUsers()) {
            for (Account account : user.getAccounts()) {
                for (Card card : account.getCards()) {
                    if (Objects.equals(card.getIdCard(), cardNumber)) {
                        return account;
                    }

                }

            }

        }

        return null;
    }

    public Account getAccountByAccNr(String accNumber) throws IOException {
        for (User user : dataAccess.getUsers()) {
            for (Account account : user.getAccounts()) {
                if (Objects.equals(account.getAccNumber(), accNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferFounds(Account account, String receiver, long amount) throws IOException {
        if (!(getAccountByAccNr(receiver).getAccNumber() == null)) {
            if (withdraw(account, amount)) {
                if (deposit(getAccountByAccNr(receiver), amount)) {
                    System.out.println("Transfer done");
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
