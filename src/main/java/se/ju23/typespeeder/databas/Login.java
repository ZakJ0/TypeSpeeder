package se.ju23.typespeeder.databas;

import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.io.Valid;

import java.sql.*;
import java.util.Optional;

public class Login {


    public long authenticateUser(String username, String password) {
        // Connect to the database and retrieve user information
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/typespeeder", "root", "Dollar1221122*")) {
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
