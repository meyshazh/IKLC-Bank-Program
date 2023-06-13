/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iklcbank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class IKLCBank {
    static ArrayList<Account> accounts = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Welcome to IKLC Bank.");
            System.out.println("1. Register Account");
            System.out.println("2. Send Money");
            System.out.println("3. Deposit Money");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();
            
            switch (choice) {
                case 1:
                    registerAccount(scanner);
                    break;
                case 2:
                    sendMoney(scanner);
                    break;
                case 3:
                    depositMoney(scanner);
                    break;
                case 0:
                    System.out.println("Thank you for using IKLC Bank.");;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
        while (choice != 0);
    }
    
    
    private static void registerAccount(Scanner scanner) {
        System.out.print("Enter account holder name : ");
        String name = scanner.next();
        System.out.print("Enter initial balance     : ");
        double balance = scanner.nextDouble();

        Account account = new Account(name, balance);
        accounts.add(account);

        System.out.println();
        System.out.println("Name            : " + account.getName());
        System.out.println("Account Number  : " + account.getAccountNumber());
        System.out.println("Balance         : " + account.getBalance());
        System.out.println("Account successfully registered on " + account.getRegistrationDate());
    }
    
    private static void sendMoney(Scanner scanner) {
        System.out.print("Enter sender account number       : ");
        int customer = scanner.nextInt();
        Account customerAccount = getAccount(customer);
        
        if (customerAccount == null) {
            System.out.println("Customer account number not found. Try again.");
            return;
        }

        System.out.print("Enter recipient account number    : ");
        int recipient = scanner.nextInt();
        Account recipientAccount = getAccount(recipient);
        
        if (recipientAccount == null) {
            System.out.println("Recipient account number not found. Try again.");
            return;
        }
        
        System.out.print("Enter amount to transfer          : ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount format. Please enter a number.");
            System.out.print("Enter amount to transfer      : ");
            scanner.next();
        }
        double amount = scanner.nextDouble();

        if (customerAccount.getBalance() < amount) {
            System.out.println("Insufficient funds.");
            return;
        }
    
        System.out.println("Transaction completed successfully.");
    }
    
    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter account number      : ");
        int customer = scanner.nextInt();
        Account customerAccount = getAccount(customer);
        
        if (customerAccount == null) {
            System.out.println("Invalid account number. Try again.");
            return;
        }
        
        System.out.print("Enter amount to deposit   : ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount format. Please enter a valid number.");
            System.out.print("Enter amount to deposit   : ");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        
        System.out.println("Deposit completed successfully.");
    }
    
    private static Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }    
}


