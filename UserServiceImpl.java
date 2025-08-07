package com.EcommerceApplication.Service.Impl;

import com.EcommerceApplication.Dto.UserDTO;
import com.EcommerceApplication.Entity.User;
import com.EcommerceApplication.Repository.UserRepository;
import com.EcommerceApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        System.out.println("Creating user: " + userDTO.getName() + " | " + userDTO.getEmail());
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
