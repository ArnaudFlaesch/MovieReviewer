package com.esgi.controllers;

import com.esgi.model.MovieEntity;
import com.esgi.repository.MovieRepository;
import com.esgi.services.MovieService;
import com.jayway.restassured.RestAssured;
import com.sun.glass.ui.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")
public class MovieControllerTest {

    @Autowired
    MovieRepository movieRepository;

    MovieEntity firstMovie;
    MovieEntity secondMovie;

    @Value("${local.server.port}")
            int port;

    @Before
    public void setUp() {

        firstMovie = new MovieEntity();
        firstMovie.setIdmovie(1L);
        firstMovie.setTitle("First");
        firstMovie.setDescription("First movie description");

        secondMovie =  new MovieEntity();
        secondMovie.setTitle("Second");
        secondMovie.setDescription("Second movie description");

        movieRepository.saveAndFlush(firstMovie);
        movieRepository.saveAndFlush(secondMovie);

        RestAssured.port = port;
    }


    @Mock
    private MovieService movieServiceMock;

    @Test
    public void should_displayMovie(){
        given().param("id",1L).when().get().then().log().all().equals("detailMovie");
    }

    @Test
    public void should_addMovieForm(){
        given().param("id",1L).when().post("/add").then().log().all().equals("addMovie");
    }

    @Test
    public void should_addMovie(){
        given().param("id",1L).when().post().then().log().all().equals("index");
    }
    @Test
    public void should_searchMoviesFromBDD(){
        given().param("id",1L).when().post("/search").then().log().all().equals("movies");
    }



}