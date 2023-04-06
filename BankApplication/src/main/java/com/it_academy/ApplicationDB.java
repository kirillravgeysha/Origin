package com.it_academy;

import service.UserService;
import service.AccountService;
import service.TransactionService;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static query_executor.TransactionQueryExecutor.*;
import static query_executor.UserQueryExecutor.*;
import static query_executor.AccountQueryExecutor.*;

public class ApplicationDB {

    private static final String DATA_BASE_URL =
            "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\resources\\mydb.db";

    public static void main(String[] args) {

        if (isDriverExists()) {
            try {
                Connection connection = DriverManager.getConnection(DATA_BASE_URL);
                int amount;
                int accountId;
                String action;
                do {
                    printMenu();
                    action = new Scanner(System.in).nextLine();
                    switch (action) {
                        case "1":
                            printAllUsers(connection);
                            break;
                        case "2":
                            UserRegister(connection, UserService.inputUser());
                            break;
                        case "3":
                            System.out.println("Enter id for delete");
                            int idForDelete = new Scanner(System.in).nextInt();
                            deleteUser(connection, idForDelete);
                            break;
                        case "4":
                            printAllAccounts(connection);
                            break;
                        case "5":
                            try {
                                AddAccount(connection, AccountService.inputAccount());
                            } catch (NumberFormatException e) {
                                System.out.println("Userid должен быть числовым значением");
                            }
                            break;
                        case "6":
                            printAllTransactions(connection);
                            break;
                        case "7":
                            try {
                                AddTransaction(connection, TransactionService.inputTransaction());
                            } catch (NumberFormatException e) {
                                System.out.println("AccountId и amount должны быть числовыми значениями");
                            }
                            amount = getAmount(connection);
                            accountId = getAccountId(connection);
                            ReplenishBalance(connection, amount, accountId);
                            break;
                        case "8":
                            try {
                                AddTransaction(connection, TransactionService.inputTransaction());
                            } catch (NumberFormatException e) {
                                System.out.println("AccountId и amount должны быть числовыми значениями");
                            }
                            amount = getAmount(connection);
                            accountId = getAccountId(connection);
                            WithdrawFromAccount(connection, amount, accountId);
                            break;
                        default:
                            System.out.println("Неверная операция ! Повторите ввод");
                            break;
                    }
                } while (!"9".equals(action));
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean isDriverExists() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver was not found");
            return false;
        }
    }

    private static void printMenu() {
        System.out.println("1 - show all users");
        System.out.println("2 - register new user");
        System.out.println("3 - delete user");
        System.out.println("4 - show all accounts");
        System.out.println("5 - add new account");
        System.out.println("6 - show all transactions");
        System.out.println("7 - replenish account");
        System.out.println("8 - withdraw from account");
        System.out.println("9 - exit");
    }
}
