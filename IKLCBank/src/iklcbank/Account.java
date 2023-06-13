/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iklcbank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Account {
    private String name;
    private int accountNumber;
    private double balance;
    private LocalDateTime registrationDate;

    public Account(String name, double balance) {
        this.name = name;
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
        this.registrationDate = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }
    
    private int generateAccountNumber() {
    Random random = new Random();
    int randomNumber = random.nextInt(900000) + 100000;
    return (randomNumber);
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    
    public String getRegistrationDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Y-M-d h:m:s");
    return registrationDate.format(formatter);
    }
}
