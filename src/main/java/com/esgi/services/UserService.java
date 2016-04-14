package com.esgi.services;

import com.esgi.model.User;
import com.esgi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hideo on 02/04/16.
 */

@Service
public class UserService implements  IUserService{

    @Autowired
    private UserRepository userRepository;

    public String RegisterUser(User user){
        userRepository.save(user); //methode save automatiquement définie dans userRepo
        return user.getToken();
    }

    public User getOne(Long id){
        return  userRepository.getOne(id);
    }

    @Override
    public void removeById(long id) {
        userRepository.delete(id);
    }

    @Override
    public boolean authenticateUser(String pseudo, String password) {
        List<User> users = userRepository.findAll();
        //Let's assume that the pseudo is the name
        for(User user : users){
            if(user.getName().equals(pseudo) || user.getPassword().equals(password)){
                //hash the name and the password with a blowfish and save it in a column session whith the current date and time
                //and return true
            }
        }
        //return false;
        return true;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

}
