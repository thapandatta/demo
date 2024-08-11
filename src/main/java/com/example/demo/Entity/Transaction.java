package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    int tid;
    int from_acc;
    int to_acc;
    double amount;


    public Transaction(int fromAccid, int toAccid, double amount) {
        this.from_acc=fromAccid;
        this.to_acc=toAccid;
        this.amount=amount;
    }

    public Transaction()
    {

    }
}
