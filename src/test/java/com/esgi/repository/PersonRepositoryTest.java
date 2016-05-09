package com.esgi.repository;


import com.esgi.MovieReviewerApplication;
import com.esgi.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MovieReviewerApplication.class)

@SqlDataPerson
public class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void should_find_all_persons() {
        assertThat(personRepository.findAll(), hasSize(3));
    }

    @Test
    public void should_find_by_idperson() {
        final Person person = personRepository.findOne("105060");

        assertThat(person, notNullValue());
        assertThat(person.getNationality(), is("français"));
    }

}
