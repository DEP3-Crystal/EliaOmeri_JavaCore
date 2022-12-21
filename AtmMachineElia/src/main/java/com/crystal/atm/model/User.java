package com.crystal.atm.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)
@Data
public class User {
    private final String id;
    private String firstName;
    private String lastName;
    private int age;
    private List<Account> accounts;

    public User(String id, String firstName, String lastName, int age, List<Account> accounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}
