package com.esgi.controllers;

import com.esgi.model.User;
import com.esgi.services.IUserService;
import com.esgi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by hideo on 02/04/16.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService _userService; //Que de l'interface ?

    @Autowired
    public UserController(UserService userService) {_userService = userService;}

    @RequestMapping(value = "/create", method = POST)
    public User create(@RequestParam("name") String name,
                       @RequestParam("password") String password,
                       @RequestParam("age") int age){

        return _userService.RegisterUser(new User(name,password,age));
    }

    @RequestMapping(value = "/getUser", method = GET)
    public User getUser(@RequestParam("id") String id){ return _userService.getOne(Long.parseLong(id));}

}
