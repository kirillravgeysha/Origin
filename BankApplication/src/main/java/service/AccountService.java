package service;

import model.Account;

import java.util.Scanner;

public class AccountService {

    public static Account inputAccount() {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id: ");
        account.setUserId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter currency: ");
        account.setCurrency(scanner.nextLine());
        return account;
    }


}
