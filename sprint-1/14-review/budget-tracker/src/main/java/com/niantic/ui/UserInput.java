package com.niantic.ui;

import com.niantic.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    private final Scanner USER_INPUT = new Scanner(System.in);

    public int homeScreenSelection() {
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

    public int reportsSelection() {
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

    public void printTransactionReportHeader(String header) {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
    }

    public void displayTransactionsReport(ArrayList<Transaction> transactions, String message) {
        if (transactions.isEmpty()) {
            System.out.println("Sorry, there are no transactions " + message);
            return;
        }
        System.out.println(transactions.size() + (transactions.size() == 1 ? " transaction was" : " transactions were") +" found");
        System.out.println("-".repeat(50));
        System.out.printf("%-10s %15s        %s\n", "Date", "Amount($)", "Notes");
        System.out.println("-".repeat(50));
        transactions.forEach(System.out::println);
    }

    public void printAddNewDataHeader(String dataType) {
        System.out.println();
        System.out.println("-".repeat(35));
        System.out.println("Add " + dataType);
        System.out.println("-".repeat(35));
        System.out.println("Enter " + dataType + " Information ");
        System.out.println();
    }

    public int getUserInteger(String message) {
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

    public String getUserString(String message) {
        System.out.print(message + ": ");
        return USER_INPUT.nextLine().strip();
    }

    public BigDecimal getUserBigDecimal(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                return new BigDecimal(USER_INPUT.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again");
            }
        }
    }

    public LocalDate getUserDate(String message) {
        while (true) {
            System.out.print(message + "(YYYY-MM-DD): ");
            try {
                return LocalDate.parse(USER_INPUT.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter your date in format YYYY-MM-DD");
            }
        }
    }

    public void printInvalidSelectionMessage() {
        System.out.println("Invalid selection, please select from the available options.");
    }


    public void printNotFoundMsg(String dataType, String dataName) {
        System.out.println("Sorry, " + dataType + " " + dataName + " was not found");
    }

    public void printNotFoundMsgAddTransaction(String dataType, String dataName) {
        printNotFoundMsg(dataType, dataName);
        System.out.println("To add a new transaction for " + dataName + " you must add this " + dataType + " first");
    }

    public void waitForUser() {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        USER_INPUT.nextLine();
    }

}
