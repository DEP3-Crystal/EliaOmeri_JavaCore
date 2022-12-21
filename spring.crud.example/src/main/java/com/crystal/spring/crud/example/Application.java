package com.crystal.spring.crud.example;

import com.crystal.spring.crud.example.entity.Person;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


	}
	@Bean
	@RequestScope
	private static List<Person> getPersonList () {

		Faker faker = new Faker();
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			personList.add(new Person(i + 1, faker.name().name(), faker.number().numberBetween(1, 100)));
		}
		return personList;
	}
}