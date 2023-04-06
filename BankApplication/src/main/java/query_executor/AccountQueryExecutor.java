package query_executor;

import model.Account;

import java.sql.*;

public class AccountQueryExecutor {

    public static void printAllAccounts(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Accounts;");
            while (resultSet.next()) {
                System.out.println("accountId: " + resultSet.getInt("accountId"));
                System.out.println("userId: " + resultSet.getInt("userId"));
                System.out.println("balance: " + resultSet.getInt("balance"));
                System.out.println("currency: " + resultSet.getString("currency"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void AddAccount(Connection connection, Account account) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Accounts (userId, currency)  VALUES (?, ?)");
            preparedStatement.setInt(1, account.getUserId());
            preparedStatement.setString(2, account.getCurrency());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e + " \nПользователь может иметь только 1 аккаунт в конкретной валюте ");
        }
    }

    public static void ReplenishBalance(Connection connection, int amount, int accountId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "Update Accounts Set balance = balance + ? where accountId = ?");
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, accountId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e + " \nБаланс аккаунта не может превышать 2’000’000’000");
        }
    }

    public static void WithdrawFromAccount(Connection connection, int amount, int accountId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "Update Accounts Set balance = balance - ? where accountId = ?");
            preparedStatement.setInt(1, amount);
            preparedStatement.setInt(2, accountId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e + " \nБаланс аккаунта не может быть отрицательным");
        }
    }
}
