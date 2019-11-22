package com.spacex.controller;

import com.spacex.api.Flight;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getFlightsPage(Model model) {
        List<Flight> flights = Flight.getAllFlights();
        model.addAttribute("flights", flights);
        return "flights";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{flight-id}")
    public String getFlightPage(Model model, @PathVariable("flight-id") int flightId, Authentication authentication) {
        Flight flight = Flight.getFlight(flightId);
        model.addAttribute("flight", flight);
        model.addAttribute("auth", authentication);
        return "main";
    }

}
