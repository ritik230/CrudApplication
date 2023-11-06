package com.example.CrudProject.Controller;

import com.example.CrudProject.Entity.Customer;
import com.example.CrudProject.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontendController {
    CustomerService cs;
    @GetMapping("/")
    public String getlogin() {
        // Implement logic to retrieve the customer list and return it
        return "login";
    }
    @GetMapping("/login")
    public String get() {
        // Implement logic to retrieve the customer list and return
        return "login";
    }
    @GetMapping("/registration")
    public String getregistered() {
        // Implement logic to retrieve the customer list and return i
        return "registration";
    }
    @GetMapping("/dashboard")
    public String getlist() {

        return "dashboard";
    }
}
