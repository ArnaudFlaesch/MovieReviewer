package com.esgi.controllers;

import com.esgi.model.Movie;
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

/**
 * Created by molla on 17/04/2016.
 */
public class IndexControllerTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringApplicationConfiguration(classes = Application.class)
    @WebAppConfiguration   // 3
    @IntegrationTest("server.port:0")
    public class MovieControllerTest {

        @Autowired
        MovieRepository movieRepository;

        Movie firstMovie;
        Movie secondMovie;

        @Value("${local.server.port}")
        int port;

        @Before
        public void setUp() {

            firstMovie = new Movie();
            firstMovie.setIdmovie(1L);
            firstMovie.setTitle("First");
            firstMovie.setDescription("First movie description");

            secondMovie = new Movie();
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
            given().param("id",1L).when().get().then().log().all().equals("index");
        }


    }
}
