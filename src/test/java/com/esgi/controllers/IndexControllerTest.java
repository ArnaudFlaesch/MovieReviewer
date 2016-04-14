package com.esgi.controllers;

import com.esgi.model.MovieEntity;
import com.esgi.services.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.jayway.restassured.RestAssured.when;
import static org.springframework.http.HttpStatus.*;
/**
 * Created by Arnaud Flaesch on 12/04/2016.
 */
@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest {

    @Test
    public void should_get_front_page() {
        when()
            .get("/")
            .then()
            .statusCode(OK.value());
    }

    /*
    @Autowired
    WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilter;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        // Setup Spring test in webapp-mode (same config as spring-boot)
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilter(springSecurityFilter, "/*")
                .build();
    }

    @Test
    public void testLoadRoot() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertNotNull(content);
        //assertTrue(content.contains("Hello Spring Boot"));
        //assertTrue(content.contains("Form Login endpoint"));
    }
    */
}