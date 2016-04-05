package com.esgi.services;

import com.esgi.model.User;
import com.esgi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hideo on 02/04/16.
 */

@Service
public class UserService implements  IUserService{

    @Autowired
    private UserRepository userRepository;

    public User RegisterUser(User user){
        userRepository.save(user); //methode save automatiquement définie dans userRepo
        return user;
    }

    public User getOne(Long id){
        return  userRepository.getOne(id);
    }

}
