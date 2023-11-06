package com.example.CrudProject.Service;

import com.example.CrudProject.Entity.Customer;
import com.example.CrudProject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;



    public boolean createCustomer(Customer customer) {
        // Check if the customer object is null, and return false if it is.
        if (customer == null) {
            System.out.println("Customer object is null. Cannot create.");
            return false;
        }

        // Print the UUID and address for debugging purposes.
        System.out.println(customer.getUuid() + " " + customer.getAddress());

        // Save the customer to the repository (assuming customerRepository is properly initialized).
        try {
            customerRepository.save(customer);
            System.out.println("Customer saved successfully.");
            return true;
        } catch (Exception e) {
            // Handle any exceptions that may occur during the save operation.
            System.err.println("Error saving customer: " + e.getMessage());
            return false;
        }
    }


    public List<Customer> getCustomerList() {
        Iterable<Customer> nearestUsers = new Iterable<Customer>() {
            @Override
            public Iterator<Customer> iterator() {
                return null;
            }
        };
          nearestUsers= customerRepository.findAll();
          ArrayList<Customer> an= new ArrayList<>();
          for(Customer c:nearestUsers){
              an.add(c);
          }

        return an;
    }

    public boolean deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return true;
    }

    public boolean updateCustomer(String uuid, Customer updatedCustomer) {
        Iterable<Customer> existingCustome = customerRepository.findAll();
        Customer existingCustomer=null;
        for(Customer c: existingCustome) if(uuid.equals(c.getUuid())){existingCustomer=c;break;}

        if (existingCustomer != null) {
            // Update the fields and save to the repository
            existingCustomer.setFirst_name(updatedCustomer.getFirst_name());
            existingCustomer.setLast_name(updatedCustomer.getLast_name());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setCity(updatedCustomer.getCity());
            existingCustomer.setState(updatedCustomer.getState());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone(updatedCustomer.getPhone());

            customerRepository.save(existingCustomer);
            return true;
        } else {
            return false; // Customer not found with the given UUID
        }
    }

    // Other methods and dependencies as needed
}

