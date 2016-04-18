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
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
         //methode save automatiquement définie dans userRepo
        return userRepository.save(user);
    }

    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void removeById(long id) {
        userRepository.delete(id);
    }

    @Override
    public User authenticateUser(String pseudo, String password) {
        User updateUser = userRepository.findByPseudoAndPassword(pseudo, password);
        if (updateUser != null) {
            updateUser.setToken();
            userRepository.save(updateUser);
            return userRepository.findByPseudoAndPassword(pseudo, password);
        }
        return (new User());
    }

    @Override
    public User updateUser(Long id, String password) {
        User updateUser = userRepository.getOne(id);
        updateUser.setPassword(password);
        return userRepository.saveAndFlush(updateUser);
    }

    @Override
    public User getUserByPseudo(String pseudo) {
        return userRepository.findByPseudo(pseudo);
    }


}
