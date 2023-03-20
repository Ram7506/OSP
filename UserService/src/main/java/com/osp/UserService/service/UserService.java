package com.osp.UserService.service;

import com.osp.UserService.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User save(User user);

    Optional<User> getUserById(long id);

    User updateUserById(User newUser);

    void deleteUserById(long id);
}
