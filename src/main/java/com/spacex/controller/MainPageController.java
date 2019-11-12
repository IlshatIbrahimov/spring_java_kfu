package com.spacex.controller;

import com.spacex.models.User;
import com.spacex.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final UserRepo userRepo;

    @Autowired
    public MainPageController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String mainPage(Map<String, Object> model) {
        User users = userRepo.findByEmail("test@mail.ru");
        return "main";
    }
}
