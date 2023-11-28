package com.example.CrudProject.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.CrudProject.Entity.*;
import com.example.CrudProject.Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="http://localhost:8080/")

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
//    final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(method = RequestMethod.POST, value ="/create_user")
    @ResponseBody
    public ResponseEntity<String> CreateUser(@RequestBody Customer r) {
        customerService.createCustomer(r);
        return ResponseEntity.status(HttpStatus.OK).body("savedCustomer");
    }

    @GetMapping("/get_user")
    public  List<Customer> getCustomerList() {
        // Implement logic to retrieve the customer list and return it
        System.out.print("aa to ra");
        List<Customer> customerList = customerService.getCustomerList(); // Assuming a service is used to fetch the list
        if (customerList == null) {
            return new ArrayList<Customer>(); // Return 204 if the list is empty
        } else {
            return customerList; // Return 200 with the customer list
        }

    }

    @DeleteMapping("/delete_user/{uuid}")
    public ResponseEntity<String> deleteCustomer(@RequestParam String uuid) {
        // Implement logic to delete a customer and return success or error response
          System.out.print(uuid);
        if (customerService.deleteCustomer(uuid)) { // Assuming a service method for deletion
            return ResponseEntity.ok("Successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UUID not found");
        }
    }

    @PutMapping("/update/{uuid}")
    public String updateCustomer( @RequestParam String uuid, @RequestBody Customer customer) {
        // Implement logic to update a customer and return success or error response
        if (customerService.updateCustomer(uuid, customer)) { // Assuming a service method for updating
            return ("Successfully Updated");
        } else {
            return ("UUID not found");
        }
    }
}
