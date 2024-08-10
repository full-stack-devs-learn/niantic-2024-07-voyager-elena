package com.niantic.application;

import com.niantic.models.*;
import com.niantic.services.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetTracker {
    private final Scanner USER_INPUT = new Scanner(System.in);
    private final CategoryDao CATEGORY_DAO = new CategoryDao();
    private final SubCategoryDao SUBCATEGORY_DAO = new SubCategoryDao();
    private final UserDao USER_DAO = new UserDao();
    private final TransactionDao TRANSACTION_DAO = new TransactionDao();
    private final VendorDao VENDOR_DAO = new VendorDao();


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
                    getTransactionsByMonth();
                    break;
                case 3:
                    // Transactions By Year
                    getTransactionsByYear();
                    break;
                case 4:
                    // Transactions By Sub Category
                    getTransactionsBySubCategory();
                    break;
                case 5:
                    // Transactions By Category
                    getTransactionsByCategory();
                    break;
                case 6:
                    // Transactions By Vendor
                    getTransactionsByVendor();
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
        System.out.println("6) Transactions By Vendor");
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
            displayTransactionsReport(transactions, "made by " + userName);
        } else {
            System.out.println("Sorry, user " + userName + " was not found");
        }

        waitForUser();
    }

    private void getTransactionsByMonth() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Transactions By Month");
        System.out.println("-".repeat(50));
        String monthName = getUserString("Please enter month: ");
        int monthNumber = getMonthNumber(monthName);
        System.out.println("Month Number: " + monthNumber);
        ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByMonth(monthNumber);
        displayTransactionsReport(transactions, "in " + monthName);
        waitForUser();
    }

    private void getTransactionsByYear() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Transactions By Year");
        System.out.println("-".repeat(50));
        int year = getUserInteger("Please enter year: ");
        ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByYear(year);
        displayTransactionsReport(transactions, "in " + year);
        waitForUser();
    }

    private void getTransactionsBySubCategory() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Transactions By Sub Category");
        System.out.println("-".repeat(50));
        String subCategoryName = getUserString("Please enter sub category name: ");
        // I tried to do something with that string to avoid false negative results when user
        // types sub category in wrong case, let say in all capital letters
        // But then I figured out that 'By default, MySQL uses a case-insensitive collation for string comparisons.
        // This means that when MySQL compares two strings, it considers ‘A’ and ‘a’ to be the same...'
        // (source https://www.geeksforgeeks.org/how-to-search-case-insensitive-in-a-column-using-like-wildcard-in-mysql)
        SubCategory subCategory = SUBCATEGORY_DAO.getSubCategoryByName(subCategoryName);

        if (subCategory != null) {
            // I know that user does not need that information, about sub category id
            // I left this print statement for testing purposes
            System.out.println("Sub Category ID: " + subCategory.getSubCategoryId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsBySubCategory(subCategory.getSubCategoryId());
            displayTransactionsReport(transactions, "in " + subCategoryName + " sub category");
        } else {
            System.out.println("Sorry, sub category " + subCategoryName + " was not found");
        }

        waitForUser();
    }

    private void getTransactionsByCategory() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Transactions By Category");
        System.out.println("-".repeat(50));
        String categoryName = getUserString("Please enter category name: ");
        Category category = CATEGORY_DAO.getCategoryByName(categoryName);

        if (category != null) {
            // I know that user does not need that information, about category id
            // I left this print statement for testing purposes
            System.out.println("Category ID: " + category.getCategoryId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByCategory(category.getCategoryId());
            displayTransactionsReport(transactions, "in " + categoryName + " category");
        } else {
            System.out.println("Sorry, category " + categoryName + " was not found");
        }

        waitForUser();
    }

    private void getTransactionsByVendor() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Transactions By Vendor");
        System.out.println("-".repeat(50));
        String vendorName = getUserString("Please enter vendor name: ");
        Vendor vendor = VENDOR_DAO.getVendorByName(vendorName);

        if (vendor != null) {
            // I know that user does not need that information, about vendor id
            // I left this print statement for testing purposes
            System.out.println("Vendor ID: " + vendor.getVendorId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByVendor(vendor.getVendorId());
            displayTransactionsReport(transactions, "for " + vendorName + " vendor");
        } else {
            System.out.println("Sorry, vendor " + vendorName + " was not found");
        }

        waitForUser();
    }

    private void displayTransactionsReport(ArrayList<Transaction> transactions, String message) {
        if (transactions.isEmpty()) {
            System.out.println("Sorry, there are no transactions " + message);
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
        return USER_INPUT.nextLine().strip();
    }

    private void waitForUser() {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        USER_INPUT.nextLine();
    }

    private int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

}
