package com.spacex.controller;

import com.spacex.api.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(Model model, Authentication authentication) {
        Flight flight = Flight.getFlight("latest");
        model.addAttribute("flight", flight);
        return "main";
    }


}
