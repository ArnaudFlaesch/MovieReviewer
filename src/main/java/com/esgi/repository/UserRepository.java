package com.esgi.repository;

import com.esgi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hideo on 02/04/16.
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
