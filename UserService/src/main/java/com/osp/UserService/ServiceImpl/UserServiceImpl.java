package com.osp.UserService.ServiceImpl;

import com.osp.UserService.Repository.UserRepository;
import com.osp.UserService.entity.User;
import com.osp.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User updateUserById(User newUser) {
        return this.save(newUser);
    }

    public void deleteUserById(long id){
        this.userRepository.deleteById(id);
    }
}
