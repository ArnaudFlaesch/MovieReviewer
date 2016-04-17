package com.esgi.services;

import com.esgi.model.User;
<<<<<<< HEAD
=======

import java.util.List;
>>>>>>> dev/users

/**
 * Created by hideo on 02/04/16.
 */
public interface IUserService {

    public User RegisterUser(User user);

    public User getOne(Long id);

    public List<User> getAll();

    void removeById(long id);

    User authenticateUser(String pseudo, String password);

    public User updateUser(Long id, String password);

    User getUserByPseudo(String pseudo);

}
