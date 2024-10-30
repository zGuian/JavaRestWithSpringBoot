package com.estudos.JavaRestWithSpringBoot.Services;

import com.estudos.JavaRestWithSpringBoot.Exceptions.ResourceNotFoundException;
import com.estudos.JavaRestWithSpringBoot.Models.Person;
import com.estudos.JavaRestWithSpringBoot.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");
        return repository.findAll();
    }

    public Person createPerson(Person person) {
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating one person");
        Person pFound = findById(person.getId());
        person.setFirstName(person.getFirstName());
        person.setLastName(person.getLastName());
        person.setAdress(person.getAdress());
        person.setGender(person.getGender());
        return repository.save(pFound);
    }

    public void deletePerson(Long id) {
        logger.info("Deleted one person:");
        Person pFound = findById(id);
        repository.delete(pFound);
    }
}
