package com.example.demo.Controller;


import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Request;
import com.example.demo.Entity.Transaction;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ClientController {


    @Autowired
    CustomerService customerService;

    @GetMapping("/allcustomers")
    public List<Customer> getall()
    {
        return customerService.getall();
    }

    @PostMapping("/addcustomer")
    public Customer addcustomer(@RequestBody Customer customer)
    {
        return customerService.addcustomer(customer);
    }

    @GetMapping("/getcustomer/{id}")
    public Customer getcustomer(@RequestParam int id)
    {
        return customerService.getcustomer(id);
    }
    @PostMapping("/addtransaction")
    public String  addTransaction(@RequestBody Request request)
    {
        return customerService.addTransaction(request);
    }

    @GetMapping("/allTransactions")
    public List<Transaction> allTransactions()
    {
        return customerService.getallTransactions();
    }

    @GetMapping("/getbybalance/{bal}")
    public List<Customer> getbybalance(@PathVariable double bal)
    {
        return customerService.getallsamebalance(bal);
    }
}
