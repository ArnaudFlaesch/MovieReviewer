package com.esgi.repository;

import com.esgi.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arnaud on 03/04/2016.
 */

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    @Query("FROM MovieEntity WHERE title LIKE %:title%")
    List<MovieEntity> findMovies(@Param("title") String title);

    @Query("FROM MovieEntity WHERE date_release <= date(now()) ORDER BY date_release DESC")
    List<MovieEntity> getLastMovies();
}
