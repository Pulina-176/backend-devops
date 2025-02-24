package com.xpensify.backend.controllers;

import com.xpensify.backend.models.User;
import com.xpensify.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/test")
    public String testPage() {
        return "test passed";
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/get-user/{username}")
    public User getUser(@PathVariable String username) {
        return userRepo.findByUsername(username).get(0);
    }

    @GetMapping("/get-user-by-id/{userId}")
    public User getUserbyID(@PathVariable long userId) {
        return userRepo.findById(userId).get(0);
    }


    @PostMapping("/add-user")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "saved user successfully";
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestBody User user) {
        userRepo.delete(user);
        return "deleted user successfully";
    }

}
