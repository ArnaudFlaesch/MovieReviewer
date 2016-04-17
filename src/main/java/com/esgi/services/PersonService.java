package com.esgi.services;

import com.esgi.model.Person;
import com.esgi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Person getPerson(long id) {
        return (personRepository.findOne(id));
    }

    @Transactional
    public List<Person> getAllPersons() {
        return(personRepository.findAll());
    }
}
