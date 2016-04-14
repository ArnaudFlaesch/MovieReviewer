package com.esgi.controllers;

import com.esgi.model.User;
import com.esgi.services.IUserService;
import com.esgi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
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

    @RequestMapping(value = "/create", method =  RequestMethod.POST)
    //@ResponseStatus(va)
    public User create(@RequestParam("name") String name,
                       @RequestParam("password") String password,
                       @RequestParam("age") int age){

        return _userService.RegisterUser(new User(name,password,age));
    }

    @RequestMapping(value = "/getUser", method = GET)
    public User getUser(@RequestParam("id") String id){ return _userService.getOne(Long.parseLong(id));}

    @RequestMapping(value = "/removeUserById", method = DELETE)
    public void removeById(@RequestParam("id") String id){ _userService.removeById(Long.parseLong(id));}

    @RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
    public boolean authenticateUser(@RequestParam("pseudo") String pseudo, @RequestParam("password") String password){
        return _userService.authenticateUser(pseudo, password);
    }

    @RequestMapping(value = "/updateInfoUser", method = RequestMethod.POST)
    public User updateUser(@RequestParam("user") User user){
        return _userService.updateUser(user);
    }
}
