package service;

import model.Transaction;

import java.util.Scanner;

public class TransactionService {

    public static Transaction inputTransaction() {
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account id: ");
        transaction.setAccountId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter amount: ");
        transaction.setAmount(Integer.parseInt(scanner.nextLine()));
        return transaction;
    }
}
