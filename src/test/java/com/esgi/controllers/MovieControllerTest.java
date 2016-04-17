package com.esgi.controllers;

import com.esgi.model.MovieEntity;
import com.esgi.repository.MovieRepository;
import com.esgi.services.MovieService;
import com.esgi.utils.MovieUtils;
import com.jayway.restassured.RestAssured;
import com.sun.glass.ui.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.jayway.restassured.RestAssured.when;
import static org.springframework.http.HttpStatus.*;


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