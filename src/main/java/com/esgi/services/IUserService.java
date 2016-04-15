package com.esgi.services;

import com.esgi.model.User;
import org.json.JSONObject;

/**
 * Created by hideo on 02/04/16.
 */
public interface IUserService {

    public String RegisterUser(User user);

    public User getOne(Long id);

    void removeById(long id);

    User authenticateUser(String pseudo, String password);

    User updateUser(User user);
}
