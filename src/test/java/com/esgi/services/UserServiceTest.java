package com.esgi.services;

import com.esgi.model.User;
import com.esgi.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by hideo on 16/04/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks private UserService _userService;

    @Mock
    private UserRepository userRepository;

    User test =new User("name", "firstname", "pseudo", "password");
    {
        this.test.setIduser(1L);
    }
    @Before
    public void setUp(){
        when(_userService.registerUser(any())).thenReturn(test);
    }


    @Test
    public void registerUser() throws Exception {


        User testRegister = _userService.registerUser(new User("name2", "firstname", "pseudo", "password"));
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
        User testRemove = _userService.registerUser(new User("test", "remove", "testest", "titi"));
        _userService.removeById(testRemove.getIduser());
        for (User user : _userService.getAll()) {
            assertNotEquals(testRemove.getPseudo(), user.getPassword());
        }
    }

    @Test
    public void authenticateUser() throws Exception {
        User user = _userService.registerUser(new User("test", "authenticate", "testes", "toto"));
        User updated = _userService.authenticateUser(user.getPseudo(), user.getPassword());
        assertEquals(user.getDateInscription(), updated.getDateInscription());
        assertEquals(user.getPassword(), updated.getPassword());
        assertNotEquals(user.getIduser(), updated.getIduser());
        assertEquals(user.getPseudo(), updated.getPassword());
        assertNotEquals(user.getToken(), updated.getToken());


    }

    @Test
    public void updateUser() throws Exception {
        _userService.updateUser(test.getIduser(), test.getPassword());
        assertNotEquals(test.getPassword(), _userService.getOne(test.getIduser()));
    }

}