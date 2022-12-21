package com.crystal.spring.crud.example.service;

import com.crystal.spring.crud.example.entity.Person;
import com.crystal.spring.crud.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person savePerson(Person person) {
        return repository.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        return repository.saveAll(persons);
    }

    public List<Person> getPersons() {
        return repository.findAll();
    }

    public Person getPersonById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Person getPersonByName(String name) {
        return repository.findByName(name);
    }

    public String deletePerson(int id) {
        repository.deleteById(id);
        return "person deleted" + id;
    }

    public Person updatePerson(Person person) {
        Person existingPerson = repository.findById(person.getId()).orElse(null);
        existingPerson.setName(person.getName());
        existingPerson.setAge(person.getAge());
        return repository.save(existingPerson);
    }


}
