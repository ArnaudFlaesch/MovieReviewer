package com.esgi.services;

import com.esgi.model.MovieEntity;
import com.esgi.repository.MovieRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    private MovieEntity movie = new MovieEntity();

    @Mock
    private MovieRepository movieRepository;

    @Test
    public void should_get_all_movies() {
        movieService.getLastMovies();
        verify(movieRepository).getLastMovies();
    }

    @Test
    public void should_modify_genre() {
        movie = movieService.getDetailMovie(new Long(1));
        movie.setGenre("Nouveau genre");
        movieRepository.save(movie);
        assertEquals(movieService.getDetailMovie(new Long(1)), "Nouveau genre");
    }


}
