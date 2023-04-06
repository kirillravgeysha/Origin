package query_executor;

import model.User;

import java.sql.*;

public class UserQueryExecutor {

    public static void printAllUsers(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users;");
            while (resultSet.next()) {
                System.out.println("userId: " + resultSet.getInt("userId"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("address: " + resultSet.getString("address"));
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void UserRegister(Connection connection, User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Users  (name, address) VALUES (?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUser(Connection connection, int idForDelete) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Users WHERE userId=?");
            preparedStatement.setInt(1, idForDelete);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
