/*
 * File: Main.java
 * Author: Joshua Francis
 * Concentration: Software Development
 * Date: 01/15/2023
 * Java class description: Driver class for this project. This project is a
 * banking program that repeatedly prompts the user for a task selection.
 * It's functionality includes deposits, withdraws, creating an account, and
 * checking the information on said account.
 */

// Main package
package LAB01;

// Imports I used
import java.util.Scanner;
import java.util.ArrayList;

// Main class
public class Main {

    // Main method
    public static void main(String[] args) {

        // Global variables that are not used for the while
        // loop below are instantiated in their respective cases
        // Variables
        char quit = 'n'; // Default for quit
        String input;
        int choice = 0; // Default for choice

        // Scanner for the users input
        Scanner scan = new Scanner(System.in);

        // Creates an ArrayList to hold the customer data.
        ArrayList<Customer> arrayOfCustomers = new ArrayList<>();

        // While statement, that determines at the end of the loop if the
        // user wants to quit out with the updated quit variable.
        while (quit != 'y') {
            System.out.println("""
                           Choose an Option:
                           1. Add Account
                           2. Find Account
                           3. Deposit Money
                           4. Withdraw Money""");

            // Allows the user to choose what they want to do. (See Cases)
            choice = scan.nextInt();

            // switch statements to choose functionality based on the users input
            switch (choice) {

                // Logic to add an account
                case 1 -> {
                    System.out.println("Chosen: Add Account");
                    System.out.println("Welcome! Enter in new account name:");
                    String name = scan.nextLine(); // Scans name from customer
                    name += scan.nextLine(); // Adds functionality for the customer to enter in a last name
                    System.out.println("Enter in beginning balance:");
                    double balance = scan.nextDouble(); // Scans beginning balance from customer
                    Customer customer = new Customer(name, balance); // Creates a new customer
                    arrayOfCustomers.add(customer); // Adds the customer to the array of customers
                    int ID = (arrayOfCustomers.size());
                    customer.setID(ID); // Sets the customers ID to the current array size
                    System.out.println("Account created! Thank you for choosing our "
                            + "bank! \nYour account number is: " + ID);
                }

                // Logic to find customer's account
                case 2 -> {
                    System.out.println("Chosen: Find Account");
                    System.out.println("Enter in account number:");
                    int findID2 = scan.nextInt() - 1; // Scans account number from customer
                    System.out.println(arrayOfCustomers.get(findID2));
                }

                // Logic to deposit funds to customer's account
                case 3 -> {
                    System.out.println("Chosen: Deposit Money");
                    System.out.println("Enter in account number:");
                    int findIDCase3 = scan.nextInt() - 1; // Scans account number from customer
                    System.out.println("Enter in amount you want to deposit:");
                    double amountToDeposit = scan.nextDouble(); // Scans the amount to deposit from customer
                    arrayOfCustomers.get(findIDCase3).deposit(amountToDeposit); // Deposits to the customer's balance
                    System.out.println("Deposited! Your balance is now: "
                            + arrayOfCustomers.get(findIDCase3).getBalance());
                }

                // Logic to withdraw funds from customer's account
                case 4 -> {
                    System.out.println("Chosen: Withdraw Money");
                    System.out.println("Enter in account number:");
                    int findIDCase4 = scan.nextInt() - 1; // Scans account number from customer
                    System.out.println("Enter in amount you want to withdraw:");
                    double amountToWithdraw = scan.nextDouble(); // Scans the amount to withdraw from customer
                    arrayOfCustomers.get(findIDCase4).withdraw(amountToWithdraw); // Withdraws from the customer's balance
                    System.out.println("Your balance is now: "
                            + arrayOfCustomers.get(findIDCase4).getBalance());
                }

                // If the customer did not enter in a value accepted
                // by the switch statement, this prompts the customer
                default ->
                    System.out.println("That was not a choice.");
            }

            // After the functions have run, asks the user if they want to quit, and
            // does so by scanning the next input and seeing the character at index 0
            // of the input variable, and sets quit equal to it.
            System.out.println("Would you like to quit y/n?");
            input = scan.next().toLowerCase();
            quit = input.charAt(0); // escapes while loop if the customer has chosen to

        }

    }

}
