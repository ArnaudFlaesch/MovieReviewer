package com.esgi.repository;

import com.esgi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arnaud on 03/04/2016.
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("FROM Movie WHERE title LIKE %:title%")
    List<Movie> findMovies(@Param("title") String title);

    @Query("FROM Movie WHERE date_release <= date(now()) ORDER BY date_release DESC")
    List<Movie> getLastMovies();
}
