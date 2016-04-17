package com.esgi.controllers;

import com.esgi.model.MovieEntity;
import com.esgi.model.ReviewEntity;
import com.esgi.repository.MovieRepository;
import com.esgi.repository.ReviewRepository;
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
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ReviewControllerTest {

    @Autowired
    ReviewRepository reviewRepository;

    ReviewEntity firstReview;
    ReviewEntity secondReview;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {

        firstReview = new ReviewEntity();

        secondReview = new ReviewEntity();


        reviewRepository.saveAndFlush(firstReview);
        reviewRepository.saveAndFlush(secondReview);

        RestAssured.port = port;
    }


    @Test
    public void should_addReview(){
        given().param("id",1L).when().post().then().log().all().equals("detailMovie");
    }

    @Test
    public void should_updateReview(){
        given().param("id",1L).when().post("/update").then().log().all().equals("detailMovie");
    }

    @Test
    public void should_deleteReview(){
        given().param("id",1L).when().post("/remove").then().log().all().equals("detailMovie");
    }


}
