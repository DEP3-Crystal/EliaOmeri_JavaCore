package com.crystal.crud.validationexample.service;

import com.crystal.crud.validationexample.dto.UserRequest;
import com.crystal.crud.validationexample.entity.User;
import com.crystal.crud.validationexample.exception.UserNotFoundException;
import com.crystal.crud.validationexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(),
                userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("user with id : " + id + " not found");
        }
    }
}
