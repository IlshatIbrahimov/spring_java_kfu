package com.spacex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class AllFlightsController {

    @GetMapping
    public String allFlights() {
        return "all";
    }

}
