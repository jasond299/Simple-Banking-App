/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jason
 */
public class BankApp {
    static Scanner input = new Scanner(System.in);
    static ArrayList<User> list = new ArrayList<>();                              // arraylist to store user accounts
    
    public static void main(String[] args) {
        
        int choice;
        int i;                                                                   // store index of account in the arraylist
        boolean quit = false;
        while(!quit){
            homeMenu();
            choice = input.nextInt();
            
            switch(choice){
                case 1: i = login();                                              // retrieve index of account with the ID and PIN
                     if (i == -1){                                               
                         System.out.println("You have entered an Invalid ID or PIN");
                     }
                     else{
                        mainMenu(i);
                     }
                     break;
                case 2: createAcc();
                     break;
                
                case 3: quit = true;
                     break;
            }
       }
        
        
    }
    
    static void homeMenu(){                                                      //home menu of the program
        System.out.println("--------Welcome to the Bank App-----------");
        System.out.println("1 - Login");
        System.out.println("2 - Create account");
        System.out.println("3 - quit");    
        
    }
    
    static void mainMenu(int i){                                                 //menu after user logs in
        int choice;
        do {
        System.out.println("--------Welcome to the Bank App-----------");                     
        System.out.println("1 - Withdraw");
        System.out.println("2 - Deposit");
        System.out.println("3 - Check balance");
        System.out.println("4 - quit");
        choice = input.nextInt();
        
        switch (choice){
            case 1 -> withdraw(i);
            case 2 -> deposit(i);
            case 3 -> System.out.println("Balance: "+ list.get(i).getBalance());
            case 4 -> {
                return;
                }
        }
        
        }while (choice < 4);
    }
    
    static int login(){                                                          // login method. Checks if the account with the entered ID and PIN exists. 
        int ID;
        int PIN;
        System.out.println("--------Welcome to the Bank App-----------");
        System.out.println("Enter ID:");
        ID = input.nextInt();
        System.out.println("Enter PIN:");
        PIN = input.nextInt();
        for (int i=0; i < list.size(); i++){                                     // search the arraylist to find an account with the entered ID and PIN
            if (ID == list.get(i).getID())                                       // return the index of the account if found
                if (PIN == list.get(i).getPIN())
                    return i;
        }
        
        return -1;
    }
    
    static void createAcc(){                                                     // create a new account
        int ID;
        int PIN;
        System.out.println("Enter your ID:");
        ID = input.nextInt();
        System.out.println("Enter your PIN:");
        PIN = input.nextInt();
        list.add(new User(ID, PIN, 0));                                          // create a new user object. sets balance at 0 
        
    }
    
    static void withdraw(int i){                                                 // withdraw from the account indexed at i in the arraylist
        int amount;
        int balance;
        System.out.println("How much would you like to withdraw");
        amount = input.nextInt();
        if (amount > list.get(i).getBalance()){
            System.out.println("Not enough funds to withdraw that amount");
        }
        else{
            balance = list.get(i).getBalance() - amount;
            list.get(i).setBalance(balance);
        }
        
    }
    
    static void deposit(int i){                                                  // deposit into the account indexed at i in the arraylist
        int amount;
        int balance;
        System.out.println("How much would you like to deposit");
        amount = input.nextInt();
        balance = list.get(i).getBalance() + amount;
        list.get(i).setBalance(balance);
    }
}
