package com.esgi.person.service;

import com.esgi.model.Person;
import com.esgi.repository.PersonRepository;
import com.esgi.services.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    private Person person = new Person();

    @Test
    public void should_get_accounts_nominal() {
        personService.getPersons();

        verify(personRepository).findAll();
    }
}
