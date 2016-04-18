package com.esgi.services;

import com.esgi.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by hideo on 16/04/16.
 */
public class UserServiceTest {

    private  UserService _userService;
    User test;
    @Before
    public void setUp(){
        test = _userService.RegisterUser(new User("name", "firstname", "pseudo", "password"));
    }


    @Test
    public void registerUser() throws Exception {
        User testRegister = _userService.RegisterUser(new User("name2", "firstname", "pseudo", "password"));
        assertNotEquals(testRegister.getIduser().longValue(),0L);
        for(User user : _userService.getAll()){
            if(user.getName().equals(testRegister.getName())){
                assertEquals(user.getFirstName(), testRegister.getFirstName());
                assertEquals(user.getDateInscription(), testRegister.getDateInscription());
                assertEquals(user.getPassword(), testRegister.getPassword());
                assertEquals(user.getPseudo(), testRegister.getPseudo());
                assertNotEquals(user.getToken(), testRegister.getToken());
            }
        }
    }

    @Test
    public void getOne() throws Exception {
        assertEquals(test, _userService.getOne(test.getIduser()));
    }

    @Test
    public void removeById() throws Exception {
        User testRemove = _userService.RegisterUser(new User("test", "remove", "testest", "titi"));
        _userService.removeById(testRemove.getIduser());
        for (User user : _userService.getAll()) {
            assertNotEquals(testRemove.getPseudo(), user.getPassword());
        }
    }

    @Test
    public void authenticateUser() throws Exception {
        User user = _userService.RegisterUser(new User("test", "authenticate", "testes", "toto"));
        User updated = _userService.authenticateUser(user.getPseudo(), user.getPassword());
        assertNotEquals(user.getIduser(), updated.getIduser());
        assertEquals(user.getPseudo(), updated.getPassword());
        assertEquals(user.getPassword(), updated.getPassword());
        assertNotEquals(user.getToken(), updated.getToken());
        assertEquals(user.getDateInscription(), updated.getDateInscription());


    }

    @Test
    public void updateUser() throws Exception {

    }

}