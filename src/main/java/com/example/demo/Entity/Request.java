package com.example.demo.Entity;


import jakarta.persistence.Entity;
import lombok.Data;


public class Request {

    int from_acc;
    int to_acc;
    double amount;
    public int getFrom_acc() {
        return from_acc;
    }

    public void setFrom_acc(int from_acc) {
        this.from_acc = from_acc;
    }

    public int getTo_acc() {
        return to_acc;
    }

    public void setTo_acc(int to_acc) {
        this.to_acc = to_acc;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
