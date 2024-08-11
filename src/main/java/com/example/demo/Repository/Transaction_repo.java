package com.example.demo.Repository;

import com.example.demo.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Transaction_repo extends JpaRepository<Transaction,Integer> {
}
