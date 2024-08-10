package com.niantic.application;

import com.niantic.models.*;
import com.niantic.services.*;
import com.niantic.ui.UserInput;

import java.util.ArrayList;

public class BudgetTracker {
    private final UserInput USER_INPUT = new UserInput();
    private final CategoryDao CATEGORY_DAO = new CategoryDao();
    private final SubCategoryDao SUBCATEGORY_DAO = new SubCategoryDao();
    private final UserDao USER_DAO = new UserDao();
    private final TransactionDao TRANSACTION_DAO = new TransactionDao();
    private final VendorDao VENDOR_DAO = new VendorDao();


    // <editor-fold desc="Main Menu - Budget Tracker">
    public void run() {

        while (true) {
            int choice = USER_INPUT.homeScreenSelection();
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
                    USER_INPUT.printInvalidSelectionMessage();
                    break;
            }
        }

    }

    // </editor-fold>

    // <editor-fold desc="Reports">
    private void displayReportsMenu() {
        while (true) {
            int choice = USER_INPUT.reportsSelection();
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
                    USER_INPUT.printInvalidSelectionMessage();
                    break;
            }
        }
    }

    private void getTransactionsByUser() {
        USER_INPUT.printTransactionReportHeader("Transactions By User");
        String userName = USER_INPUT.getUserString("Please enter user name: ");
        User user = USER_DAO.getUserByName(userName);

        if (user != null) {
            System.out.println("User ID: " + user.getUserId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByUser(user.getUserId());
            USER_INPUT.displayTransactionsReport(transactions, "made by " + userName);
        } else {
            System.out.println("Sorry, user " + userName + " was not found");
        }

        USER_INPUT.waitForUser();
    }

    private void getTransactionsByMonth() {
        USER_INPUT.printTransactionReportHeader("Transactions By Month");
        String monthName = USER_INPUT.getUserString("Please enter month: ");
        int monthNumber = DateConverter.getMonthNumber(monthName);
        System.out.println("Month Number: " + monthNumber);
        ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByMonth(monthNumber);
        USER_INPUT.displayTransactionsReport(transactions, "in " + monthName);
        USER_INPUT.waitForUser();
    }

    private void getTransactionsByYear() {
        USER_INPUT.printTransactionReportHeader("Transactions By Year");
        int year = USER_INPUT.getUserInteger("Please enter year: ");
        ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByYear(year);
        USER_INPUT.displayTransactionsReport(transactions, "in " + year);
        USER_INPUT.waitForUser();
    }

    private void getTransactionsBySubCategory() {
        USER_INPUT.printTransactionReportHeader("Transactions By Sub Category");
        String subCategoryName = USER_INPUT.getUserString("Please enter sub category name: ");
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
            USER_INPUT.displayTransactionsReport(transactions, "in " + subCategoryName + " sub category");
        } else {
            System.out.println("Sorry, sub category " + subCategoryName + " was not found");
        }

        USER_INPUT.waitForUser();
    }

    private void getTransactionsByCategory() {
        USER_INPUT.printTransactionReportHeader("Transactions By Category");
        String categoryName = USER_INPUT.getUserString("Please enter category name: ");
        Category category = CATEGORY_DAO.getCategoryByName(categoryName);

        if (category != null) {
            System.out.println("Category ID: " + category.getCategoryId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByCategory(category.getCategoryId());
            USER_INPUT.displayTransactionsReport(transactions, "in " + categoryName + " category");
        } else {
            System.out.println("Sorry, category " + categoryName + " was not found");
        }

        USER_INPUT.waitForUser();
    }

    private void getTransactionsByVendor() {
        USER_INPUT.printTransactionReportHeader("Transactions By Vendor");
        String vendorName = USER_INPUT.getUserString("Please enter vendor name: ");
        Vendor vendor = VENDOR_DAO.getVendorByName(vendorName);

        if (vendor != null) {
            System.out.println("Vendor ID: " + vendor.getVendorId());
            ArrayList<Transaction> transactions = TRANSACTION_DAO.getTransactionsByVendor(vendor.getVendorId());
            USER_INPUT.displayTransactionsReport(transactions, "for " + vendorName + " vendor");
        } else {
            System.out.println("Sorry, vendor " + vendorName + " was not found");
        }

        USER_INPUT.waitForUser();
    }

    // </editor-fold>

}
