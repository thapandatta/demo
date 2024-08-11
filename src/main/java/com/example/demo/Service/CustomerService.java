package com.example.demo.Service;


import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Request;
import com.example.demo.Entity.Transaction;
import com.example.demo.Repository.Transaction_repo;
import com.example.demo.Repository.customer_repo;
import com.example.demo.getRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    getRandom rand;

    @Autowired
    customer_repo customerRepo;


    @Autowired
    Transaction_repo transactionRepo;

    public List<Customer> getall() {
        return customerRepo.findAll();
    }

    public Customer addcustomer(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    public Customer getcustomer(int id) {
        Optional<Customer> op=customerRepo.findById(id);
        return op.orElseGet(Customer::new);
    }

    public String addTransaction(Request request) {
        int from_accid=request.getFrom_acc();
        int to_accid=request.getTo_acc();
        double amount=request.getAmount();
        Optional<Customer> ac1=customerRepo.findById(from_accid);
        Optional<Customer> ac2=customerRepo.findById(to_accid);
        if(ac1.isEmpty() || ac2.isEmpty())
        {
            return "enter valid credentials";
        }
        if(ac1.get().getBalance()<amount)
        {
            return "insufficient funds";
        }
        Transaction t1=new Transaction(from_accid,to_accid,amount);
        transactionRepo.save(t1);
        ac1.get().setBalance(ac1.get().getBalance()-amount);
        ac2.get().setBalance(ac2.get().getBalance()+amount);
        customerRepo.save(ac1.get());
        customerRepo.save(ac2.get());
        return "transaction success";
    }

    public List<Transaction> getallTransactions() {
        return transactionRepo.findAll();
    }

    public List<Customer> getallsamebalance(double d)
    {
        return customerRepo.findByBalance(d);
    }
}
