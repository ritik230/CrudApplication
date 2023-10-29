package com.example.CrudProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendController {
    @GetMapping("/")
    public String get() {
        // Implement logic to retrieve the customer list and return it
        return "login";
    }
    @GetMapping("/registration")
    public String getregistered() {
        // Implement logic to retrieve the customer list and return it
        System.out.print("registration");
        return "registration";
    }
    @PostMapping("login")
    public String getlogin() {
        // Implement logic to retrieve the customer list and return it
        return "login";
    }
    @PostMapping("dashboard")
    public String getlist() {

        // Implement logic to retrieve the customer list and return it
        return "dashboard";
    }
}
