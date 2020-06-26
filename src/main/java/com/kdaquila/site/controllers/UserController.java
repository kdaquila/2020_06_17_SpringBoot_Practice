package com.kdaquila.site.controllers;

import com.kdaquila.site.models.User;
import com.kdaquila.site.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
