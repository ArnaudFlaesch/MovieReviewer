package com.esgi.services;

import com.esgi.model.User;

import java.util.List;

/**
 * Created by hideo on 02/04/16.
 */
public interface IUserService {

    public User RegisterUser(User user);

    public User getOne(Long id);

    public List<User> getAll();

    void removeById(long id);

    User authenticateUser(String pseudo, String password);

    User updateUser(User user);

    User getUserByPseudo(String pseudo);

}
