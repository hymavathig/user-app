package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user){
        User u = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found id"));
        u.setEmail(user.getEmail());
        u.setPhno(user.getPhno());
        return userRepository.save(u);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
