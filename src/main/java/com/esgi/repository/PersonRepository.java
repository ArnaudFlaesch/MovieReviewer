package com.esgi.repository;

import com.esgi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Class PersonRepository
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT a FROM Person a WHERE idperson = :idperson")
    Person findOne(@Param("idperson")String aString);
}
