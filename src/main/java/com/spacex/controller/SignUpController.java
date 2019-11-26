package com.spacex.controller;

import com.spacex.forms.SignUpForm;
import com.spacex.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService service;

    @PreAuthorize("permitAll()")
    @PostMapping

    public String signUpUser(SignUpForm form) {
        if (service.signUp(form)) {
            return "redirect:/flights";
        } else {
            return "redirect:/signUp?error";
        }
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public String signUp(@RequestParam Map<String, String> params, Model model) {
        if (params.containsKey("error")) {
            model.addAttribute("error", "User with this email already exists!");
        }
        return "signUp";
    }
}
