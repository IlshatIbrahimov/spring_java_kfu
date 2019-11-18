package com.spacex.controller;

import com.spacex.forms.SignUpForm;
import com.spacex.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService service;

    @PreAuthorize("permitAll()")
    @PostMapping
    public String signUpUser(SignUpForm form) {
        service.signUp(form);
        return "redirect:/login";
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public String signUp() {
        return "signUp";
    }
}
