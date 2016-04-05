package com.esgi.services;

import com.esgi.model.User;

/**
 * Created by hideo on 02/04/16.
 */
public interface IUserService {

    public User RegisterUser(User user);
    public User getOne(Long id);
}
