package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model){
        model.addAttribute("user", username);
        return "profile";
    }

    @PostMapping("/profile")
    public String viewLoginInfo(@RequestParam(name = "user") String username, @RequestParam(name = "password") String password, Model model){
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "profile";
    }
}
