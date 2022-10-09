package com.crystal.atm.dao;

import com.crystal.atm.model.User;

import java.io.IOException;
import java.util.List;

public interface DataAccess {
      List<User> getUsers() throws IOException;

     void setUser(User user) throws IOException;
     void setUsers() throws IOException;
}
