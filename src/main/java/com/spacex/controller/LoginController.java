package com.spacex.controller;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @PreAuthorize("permitAll()")
    @GetMapping
    public String getLoginPage(@RequestParam Map<String, String> params, Model model) {
        if (params.containsKey("error")) {
            model.addAttribute("error", "Wrong email or password!");
        }
        return "login";
    }

}
