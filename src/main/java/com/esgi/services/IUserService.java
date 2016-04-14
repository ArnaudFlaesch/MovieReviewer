package com.esgi.services;

import com.esgi.model.User;

/**
 * Created by hideo on 02/04/16.
 */
public interface IUserService {

    public String RegisterUser(User user);

    public User getOne(Long id);

    void removeById(long id);

    boolean authenticateUser(String pseudo, String password);

    User updateUser(User user);
}
