package com.crystal.atm.dao;

import com.crystal.atm.model.Account;
import com.crystal.atm.model.Card;
import com.crystal.atm.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFromMemory implements DataAccess {
    private List<User> users = new ArrayList<>();

    public DataAccessFromMemory() {
        users = getUsersInfo();
    }

    @Override
    public List<User> getUsers() {
        return users;

    }

    public List<User> getUsersInfo() {


        List<User> users = new ArrayList<>();

        //Account(String userId, String accNumber,String iban,  long balance, List<Card> cards)
        //Card(String idCard, String accountId, String pin, String cvv, int validMonth, int validYear)
        //User(String id, String firstName, String lastName, int age, List<Account> accounts)


        users.add(new User("1", "Elia", "Omeri", 23,
                List.of(new Account("1", "2", "abn456", 1500
                        , List.of(new Card("00", "2", "236", "365", 1, 2022)))
                )));
        users.add(new User("2", "Ana", "Ana", 26,
                List.of(new Account("2", "255", "abn456", 1500,
                        List.of(new Card("01", "255", "236", "365", 1, 2022))))));
        return users;
    }


    @Override
    public void setUser(User user) {
        users.add(user);
    }

    @Override
    public void setUsers() throws IOException {

    }
}
