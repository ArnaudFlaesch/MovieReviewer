package com.esgi.services;

import com.esgi.model.Movie;
import com.esgi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Arnaud on 03/04/2016.
 */
@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Transactional
    public Movie getDetailMovie(Long id) {
        return (movieRepository.getOne(id));
    }

    @Transactional
    public List<Movie> getLastMovies() {
        return(movieRepository.getLastMovies());
    }

    @Transactional
    public List<Movie> searchMovies(String titleSearch) {
        return(movieRepository.findMovies(titleSearch));
    }

}