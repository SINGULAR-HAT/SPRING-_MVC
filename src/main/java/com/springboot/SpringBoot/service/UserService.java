package com.springboot.SpringBoot.service;

import com.springboot.SpringBoot.dao.UserRepository;
import com.springboot.SpringBoot.model.User;
import com.springboot.SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    public void save(User user) {
        userRepo.save(user);
    }
    public User getById(Long id) {
        Optional<User> optional = userRepo.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                    "User not found for id : " + id);
        return user;
    }
        public void deleteViaId(long id) {
        userRepo.deleteById(id);
    }
}
