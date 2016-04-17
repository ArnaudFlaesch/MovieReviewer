package com.esgi.services;

import com.esgi.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by hideo on 16/04/16.
 */
public class UserServiceTest {

    private  UserService _userService;



    @Test
    public void registerUser() throws Exception {
        User test = _userService.RegisterUser(new User("name", "firstname", "pseudo", "password"));
        assertEquals(_userService.getOne(1L),test);
    }

    @Test
    public void getOne() throws Exception {

    }

    @Test
    public void removeById() throws Exception {

    }

    @Test
    public void authenticateUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {

    }

}