package com.esgi.controllers;

import com.esgi.model.User;
import com.esgi.services.IUserService;
import com.esgi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by hideo on 02/04/16.
 */

@RestController
@RequestMapping("/user")
public class UserController {


    private IUserService _userService; //Que de l'interface ?

    @Autowired
    public UserController(IUserService userService) {_userService = userService;}

    @RequestMapping(value = "/create",method = POST)
    public long create(User user){
        return _userService.RegisterUser(user);
    }
}
