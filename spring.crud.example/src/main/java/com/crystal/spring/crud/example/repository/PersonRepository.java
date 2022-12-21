package com.crystal.spring.crud.example.repository;

import com.crystal.spring.crud.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findByName(String name);
}
