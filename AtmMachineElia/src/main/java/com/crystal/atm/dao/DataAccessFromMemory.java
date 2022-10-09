package com.crystal.atm.dao;

import com.crystal.atm.model.Account;
import com.crystal.atm.model.Card;
import com.crystal.atm.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFromMemory implements DataAccess{
    private List<User> users=new ArrayList<>();

    public DataAccessFromMemory() {
        users=getUsersInfo();
    }

    @Override
    public List<User> getUsers() {
        return users;

    }
    public List<User> getUsersInfo() {


        List<User> users=new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        List<Account> accounts2 = new ArrayList<>();
        List<Card> cards = new ArrayList<>();
        //Account(String userId, String accNumber,String iban,  long balance, List<Card> cards)
        //Card(String idCard, String accountId, String pin, String cvv, int validMonth, int validYear)
        //User(String id, String firstName, String lastName, int age, List<Account> accounts)
        cards.add(new Card("00","ab1234","236","365",1,2022));
        accounts.add(new Account("ab1234","1","jhdl5638",1000,cards));
        accounts.add(new Account("ab1234","1","536pp89",2000,cards));

        users.add(new User("1","Elia","Omeri",23,accounts));
        accounts2.add(new Account("ac1234","2","abn456",1500,cards));
        accounts2.add(new Account("ac1234","2","hj25896",5000,cards));
        users.add(new User("1","Ana","Ana",26,accounts2));
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
