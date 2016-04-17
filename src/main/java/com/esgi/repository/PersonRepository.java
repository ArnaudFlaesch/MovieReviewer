package com.esgi.repository;

import com.esgi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class PersonRepository
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
