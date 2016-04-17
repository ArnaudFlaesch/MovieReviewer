package com.esgi.controllers;

import com.esgi.model.User;
import com.esgi.services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by hideo on 02/04/16.
 */

@RestController
@RequestMapping("/user")
public class UserAPIController {

    private UserService _userService; //Que de l'interface ?

    @Autowired
    public UserAPIController(UserService userService) {
        _userService = userService;
    }

    @RequestMapping(value = "/")
    public String UserUtils() {
        return ("userUtils");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name,
                         @RequestParam("firstName") String firstname,
                         @RequestParam("pseudo") String pseudo,
                         @RequestParam("password") String password) {


        JSONObject json = new JSONObject();
        User createdUser = _userService.RegisterUser(new User(name, firstname, pseudo, password));
        json.put("id", createdUser.getIduser());
        json.put("name", createdUser.getName());
        json.put("firstName", createdUser.getFirstName());
        json.put("pseudo", createdUser.getPseudo());
        json.put("dateInscription", createdUser.getDateInscription());
        json.put("token", createdUser.getToken());
        return json.toString();
    }

    @RequestMapping(value = "/getUserById", method = GET)
    public User getUser(@RequestParam("id") String id) {
        return _userService.getOne(Long.parseLong(id));
    }

    @RequestMapping(value = "/removeUserById", method = DELETE)
    public void removeById(@RequestParam("id") String id) {
        _userService.removeById(Long.parseLong(id));
    }

    @RequestMapping(value = "/authentificateUser", method = RequestMethod.POST)
    public String authenticateUser(@RequestParam("pseudo") String pseudo, @RequestParam("password") String password) {
        User authUser = _userService.authenticateUser(pseudo, password);

        JSONObject json = new JSONObject();
        if (authUser.getToken() == null) {
            json.put("token", -1);
        } else {
            json.put("token", authUser.getToken());
        }
        return json.toString();
    }

    @RequestMapping(value = "/updatePasswordUser", method = RequestMethod.POST)
    public User updateUser(@RequestParam("id") Long id, @RequestParam("password") String password) {
        return _userService.updateUser(id, password);
    }

    @RequestMapping(value = "/getUserByPseudo", method = RequestMethod.GET)
    public String getUserByPseudo(@RequestParam("pseudo") String pseudo) {

        User getUser = _userService.getUserByPseudo(pseudo);
        JSONObject json = new JSONObject();
        try {
            json.put("id", getUser.getIduser());
            json.put("name", getUser.getName());
            json.put("firstName", getUser.getFirstName());
            json.put("pseudo", getUser.getPseudo());
            json.put("dateInscription", getUser.getDateInscription());
            json.put("token", getUser.getToken());
        } catch (NullPointerException e) {
            json.put("error", "User doesn't exist");

        }
        return json.toString();

    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return _userService.getAll();
    }
}