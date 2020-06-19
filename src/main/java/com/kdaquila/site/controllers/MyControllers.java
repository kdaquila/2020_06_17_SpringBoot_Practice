package com.kdaquila.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyControllers {

    @GetMapping("/")
    public String home(@RequestParam(name="logout", required = false, defaultValue = "false") String logout, Model model) {
        model.addAttribute("logout", logout);
        return "home";
    }

    @GetMapping("/secureGreeting")
    public String secureGreeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "secureGreeting";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
