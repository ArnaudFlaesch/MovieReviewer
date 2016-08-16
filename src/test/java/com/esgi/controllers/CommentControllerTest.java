package com.esgi.controllers;

import com.esgi.model.Comment;
import com.esgi.repository.CommentRepository;
import com.jayway.restassured.RestAssured;
import com.sun.glass.ui.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class CommentControllerTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringApplicationConfiguration(classes = Application.class)
    @WebAppConfiguration
    @IntegrationTest("server.port:0")
    public class MovieControllerTest {

        @Autowired
        CommentRepository commentRepository;

        Comment firstComment;
        Comment secondComment;

        @Value("${local.server.port}")
        int port;

        @Before
        public void setUp() {

            firstComment = new Comment();
            firstComment.setComment("First comment");

            secondComment = new Comment();
            secondComment.setComment("Second comment");

            commentRepository.saveAndFlush(firstComment);
            commentRepository.saveAndFlush(secondComment);

            RestAssured.port = port;
        }

        @Test
        public void should_addComment() {
            given().param("id",1L).when().post().then().log().all().equals("detailMovie");
        }

        @Test
        public void should_updateComment() {
            given().param("id",1L).when().post("/update").then().log().all().equals("detailMovie");
        }

        @Test
        public void should_deleteComment() {
            given().param("id",1L).when().post("/remove").then().log().all().equals("detailMovie");
        }


    }
}
