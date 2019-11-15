package com.spacex.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getFlightsPage() {
        return "flights";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{flight-id}")
    public String getFlightPage(@PathVariable("flight-id") Long flightId) {
        return "flight";
    }

}
