package com.esgi.repository;

import com.esgi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by hideo on 02/04/16.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //@Query(value = "SELECT name,firstName,pseudo,dateInscription,token FROM User WHERE pseudo = :pseudo AND password = :password")
    User findByPseudoAndPassword(@Param("pseudo") String pseudo, @Param("password") String password);

}
