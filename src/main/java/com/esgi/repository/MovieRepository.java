package com.esgi.repository;

import com.esgi.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arnaud on 03/04/2016.
 */

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
