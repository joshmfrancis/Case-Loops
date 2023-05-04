/*
 * File: Main.java
 * Author: Joshua Francis
 * Concentration: Software Development
 * Date: 01/15/2023
 * Java class description: Helper class to handle customer data and other things
 * like customer deposits and withdraws.
 */

// Main package
package LAB01;

// Import I Used
import java.text.DecimalFormat;

/**
 * Main class
 * @author josh
 */
public class Customer {

    // Variables
    String name;
    double balance;
    int ID;

    // Decimal Formatter for Currency
    DecimalFormat dollarFmt = new DecimalFormat("$0.00");
    
    /**
     * Default Constructor
     * @param name
     * @param balance 
     */
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // SETTERS

    /**
     * Setter for the customer's name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter for the customer's balance
     * @param balance 
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Setter for the customer's ID number
     * @param ID 
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    // ACTIONS

    /**
     * Logic to deposit money into the customer's account
     * @param deposit 
     */
    public void deposit(double deposit) {
        balance += deposit;
    }

    /**
     * Logic to withdraw money from the customer's account
     * @param withdraw 
     */
    public void withdraw(double withdraw) {
        // If the user does not have the availiable funds
        if (balance < withdraw) {
            // Prompt the user and don't withdraw
            System.out.println("You do not have enough on funds to withdraw "
                    + dollarFmt.format(withdraw));
        } // Else, withdraw the funds
        else {
            balance -= withdraw;
        }
    }

    // GETTERS

    /**
     * Getter for the customer's balance
     * @return 
     */
    public String getBalance() {
        return dollarFmt.format(balance); // Returns balance formatted
    }

    // TOSTRING

    @Override
    /**
     * ToString Method to print out the customers Information (Case 2: Find Account)
     */
    public String toString() {
        String output = "";
        output += "Information: \nName: " + name + "\nBalance: " + dollarFmt.format(balance);
        return output;
    }
}
