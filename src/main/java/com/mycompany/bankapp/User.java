/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp;

/**
 * User class object
 * attributes: ID, PIN, balance
 * @author jason
 */
public class User {
    private int ID;
    private int PIN;
    private int balance;
    
    public User(int ID, int PIN, int balance){
        this.ID = ID;
        this.PIN = PIN;
        this.balance = balance;
    }
    
    public void setID(int ID){
        this.ID = ID;
}
    
    public void setPIN(int PIN){
        this.PIN = PIN;
    }
    
    public void setBalance(int balance){
        this.balance = balance;
    }
    
    public int getID(){
        return ID;
    }
    
    public int getPIN() {
        return PIN;
    }
    
    public int getBalance() {
        return balance;
}
}
