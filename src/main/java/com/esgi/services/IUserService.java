package com.esgi.services;

import com.esgi.model.User;
import java.util.List;

/**
 * Created by hideo on 02/04/16.
 */
public interface IUserService {

    public User registerUser(User user);

    public User getOne(Long id);

    public List<User> getAll();

    void removeById(long id);

    User authenticateUser(String pseudo, String password);

    public User updateUser(Long id, String password);

    User getUserByPseudo(String pseudo);

}
