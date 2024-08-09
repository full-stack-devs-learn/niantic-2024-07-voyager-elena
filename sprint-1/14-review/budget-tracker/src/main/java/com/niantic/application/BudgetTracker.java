package com.niantic.application;

import com.niantic.models.Transaction;
import com.niantic.models.User;
import com.niantic.services.CategoryDao;
import com.niantic.services.TransactionDao;
import com.niantic.services.UserDao;

import java.util.ArrayList;
import java.util.Scanner;

public class BudgetTracker {
    private final Scanner USER_INPUT = new Scanner(System.in);
    private final CategoryDao CATEGORY_DAO = new CategoryDao();
    private final UserDao USER_DAO = new UserDao();
    private final TransactionDao TRANSACTION_DAO = new TransactionDao();


    // <editor-fold desc="Main Menu - Budget Tracker">
    public void run() {

        while (true) {
            int choice = homeScreenSelection();
            switch (choice) {
                case 1:
                    System.out.println("add transaction");
                    break;
                case 2:
                    displayReportsMenu();
                    break;
                case 3:
                    System.out.println("add user");
                    break;
                case 4:
                    System.out.println("add category");
                    break;
                case 5:
                    System.out.println("add sub category");
                    break;
                case 6:
                    System.out.println("add vendor");
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Budget Tracker!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                default:
                    printInvalidSelectionMessage();
                    break;
            }
        }

    }

    private int homeScreenSelection() {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("-".repeat(35));
        System.out.println("MAIN MENU");
        System.out.println("-".repeat(35));
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("1) Add Transaction");
        System.out.println("2) Reports");
        System.out.println("3) Add User");
        System.out.println("4) Add Category");
        System.out.println("5) Add Sub Category");
        System.out.println("6) Add Vendor");
        System.out.println("0) Quit");
        System.out.println();

        return getUserInteger("Enter your selection: ");
    }
    // </editor-fold>

    // <editor-fold desc="Reports">
    private void displayReportsMenu() {
        while (true) {
            int choice = reportsSelection();
            switch (choice) {
                case 1:
                    // Transactions By User
                    getTransactionsByUser();
                    break;
                case 2:
                    // Transactions By Month
                    System.out.println("Transactions By Month");
                    break;
                case 3:
                    // Transactions By Year
                    System.out.println("Transactions By Year");
                    break;
                case 4:
                    // Transactions By Sub Category
                    System.out.println("Transactions By Sub Category");
                    break;
                case 5:
                    // Transactions By Category
                    System.out.println("Transactions By Category");
                    break;
                case 0:
                    // go back to home screen
                    return;
                default:
                    printInvalidSelectionMessage();
                    break;
            }
        }
    }

    private int reportsSelection() {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("-".repeat(35));
        System.out.println("REPORTS");
        System.out.println("-".repeat(35));
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("1) Transactions By User");
        System.out.println("2) Transactions By Month");
        System.out.println("3) Transactions By Year");
        System.out.println("4) Transactions By Sub Category");
        System.out.println("5) Transactions By Category");
        System.out.println("0) Back to Main Menu");
        System.out.println();

        return getUserInteger("Enter your selection: ");
    }

    private void getTransactionsByUser() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Transactions By User");
        System.out.println("-".repeat(50));
        String userName = getUserString("Please enter user name: ");
        User user = USER_DAO.getUserByName(userName);

        if (user != null) {
            System.out.println("User ID: " + user.getUserId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByUser(user.getUserId());
            displayTransactionsByUserReport(transactions, userName);
        } else {
            System.out.println("Sorry, user  " + userName + " was not found");
        }

        waitForUser();
    }

    private void displayTransactionsByUserReport(ArrayList<Transaction> transactions, String userName) {
        if (transactions.isEmpty()) {
            System.out.println("Sorry, there are no transactions made by  " + userName);
            return;
        }
        System.out.println(transactions.size() + " transactions were found");
        System.out.println("-".repeat(50));
        System.out.printf("%-10s %15s        %s\n", "Date", "Amount($)", "Notes");
        System.out.println("-".repeat(50));
        transactions.forEach(System.out::println);
    }


    // </editor-fold>

    private int getUserInteger(String message) {
        int number = -1;

        while (number < 0) {
            System.out.print(message);
            try {
                number = Integer.parseInt(USER_INPUT.nextLine());
            } catch (Exception e) {
                printInvalidSelectionMessage();
            }
        }

        return number;
    }

    private void printInvalidSelectionMessage() {
        System.out.println("Invalid selection, please select from the available options.");
    }

    private String getUserString(String message) {
        System.out.print(message);
        return USER_INPUT.nextLine();
    }

    private void waitForUser() {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        USER_INPUT.nextLine();
    }

}
