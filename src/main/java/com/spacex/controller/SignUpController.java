package com.spacex.controller;

import com.spacex.forms.SignUpForm;
import com.spacex.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService service;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ModelAndView signUpUser(SignUpForm form) {

        RedirectView redirectSuccess = new RedirectView("/login");
        RedirectView redirectFailure = new RedirectView("/login?error");
        if (service.signUp(form)) {
            return new ModelAndView("redirect:/login");
        } else {
//            redirectFailure.addStaticAttribute("errorMessage",
//                    "User with this email already exists!");
            return new ModelAndView("redirect:" + "welcome", "errorMessage", "User with this email already exists!");
        }

    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public String signUp() {
        return "signUp";
    }
}
