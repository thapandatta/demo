package com.example.demo.Repository;


import com.example.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface customer_repo extends JpaRepository<Customer, Integer> {

    List<Customer> findByBalance(double d);
}
