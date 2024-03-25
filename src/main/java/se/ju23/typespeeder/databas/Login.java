package se.ju23.typespeeder.databas;
/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-20
 */
import se.ju23.typespeeder.Menu;

import java.sql.*;
public class Login {

    public long authenticateUser(String username, String password) {
        // Connect to the database and retrieve user information
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/typespeeder", "root", "Java1234")) {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {
                        return resultSet.getInt("userid"); // Returns true if a matching user is found
                    } else {
                        return -1;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
