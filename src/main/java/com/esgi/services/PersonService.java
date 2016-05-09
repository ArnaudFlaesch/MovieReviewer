package com.esgi.services;

import com.esgi.model.Person;
import com.esgi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PersonService
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public Person getPerson(long id) {
        return (personRepository.findOne(id));
    }

    @Transactional(readOnly = true)
    public List<Person> getPersons() {
        return (personRepository.findAll());
    }

    @Transactional
    public boolean saves(ArrayList<Person> listPersons) {
        for (Person person : listPersons) {
            personRepository.save(person);
        }
        return true;
    }
}
