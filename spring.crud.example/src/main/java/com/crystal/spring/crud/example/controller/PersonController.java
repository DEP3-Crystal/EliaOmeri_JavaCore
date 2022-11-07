package com.crystal.spring.crud.example.controller;

import com.crystal.spring.crud.example.entity.Person;
import com.crystal.spring.crud.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private List<Person> persons;

    @GetMapping("/persons")
    public List<Person> getPersonList(){
        return persons;
    }
    @Autowired
    private PersonService service;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return service.savePerson(person);
    }
    @PostMapping("/addPersons")
    public List<Person> addPerson(@RequestBody List<Person> persons){
        return service.savePersons(persons);
    }
    //    @GetMapping("/persons")
//    public List<Person> findAllPersons(){
//        return service.getPersons();
//    }
//    @GetMapping("/getPersons/{id}")
//    public Person findPersonById(@PathVariable  int id){
//        return service.getPersonById(id);
//    }
//    @GetMapping("/getPersons/{name}")
//    public Person findPersonByName(@PathVariable String name){
//        return service.getPersonByName(name);
//    }
    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person){
        return service.updatePerson(person);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id){
        return service.deletePerson(id);
    }
}
