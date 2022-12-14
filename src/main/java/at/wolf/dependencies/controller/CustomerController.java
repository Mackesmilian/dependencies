package at.wolf.dependencies.controller;

import at.wolf.dependencies.View;
import at.wolf.dependencies.entity.Customer;
import at.wolf.dependencies.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @JsonView(View.Public.Info.class)
    @GetMapping("/customers")
    List<Customer> all() {
        return customerService.findAll();
    }

    @JsonView(View.Public.Balance.class)
    @GetMapping("/customers/balance")
    List<Customer> allBalance() {
        return customerService.findAll();
    }
}
