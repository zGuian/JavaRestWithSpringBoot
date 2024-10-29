package com.estudos.JavaRestWithSpringBoot.Services;

import com.estudos.JavaRestWithSpringBoot.Models.Person;
import org.apache.juli.ClassLoaderLogManager;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Guian");
        person.setLastName("Rocha");
        person.setAdress("SBC - SP");
        person.setGender("Betoneira");

        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding many person!");

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person createPerson(Person person) {
        logger.info("Creating one person");
        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating one person");
        return person;
    }

    public void deletePerson(String id) {
        logger.info("Deleted one person:");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAdress("Local " + i);
        person.setGender("Betoneira");
        return person;
    }
}
