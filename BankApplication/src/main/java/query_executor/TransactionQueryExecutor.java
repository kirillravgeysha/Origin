package query_executor;

import model.Transaction;

import java.sql.*;

public class TransactionQueryExecutor {

    public static void printAllTransactions(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Transactions;");
            while (resultSet.next()) {
                System.out.println("transactinId: " + resultSet.getInt("transactinId"));
                System.out.println("accountId: " + resultSet.getInt("accountId"));
                System.out.println("amount: " + resultSet.getInt("amount"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAmount(Connection connection) {
        int amount = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT amount FROM Transactions;");
            while (resultSet.next()) {
                amount = resultSet.getInt("amount");
            }
            statement.close();
            resultSet.close();
            return amount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAccountId(Connection connection) {
        int accountId = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT accountId FROM Transactions;");
            while (resultSet.next()) {
                accountId = resultSet.getInt("accountId");
            }
            statement.close();
            resultSet.close();
            return accountId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void AddTransaction(Connection connection, Transaction transaction) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Transactions (accountId, amount) VALUES (?, ?)");
            preparedStatement.setInt(1, transaction.getAccountId());
            preparedStatement.setInt(2, transaction.getAmount());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e + " \nРазмер транзакции не может быть отрицательным и превышать 100’000’000");
        }
    }

}
