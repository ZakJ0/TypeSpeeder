package se.ju23.typespeeder.io;
/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-20
 */

import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.databas.Login;
import se.ju23.typespeeder.databas.User;

import java.util.Optional;

public class UserCreateUpdate {

    Login login = new Login();

    Valid valid = new Valid();

    public void updateUserInDatabase() {
        System.out.println("Update user information");
        System.out.print("Write  userID to uppdate: ");
        long userIdToUpdate = valid.readLongOnly();

        Optional<User> optionalUser = Main.iuser.findById(userIdToUpdate);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            System.out.print("write your username: ");
            existingUser.setUsername(valid.validInput());

            System.out.print("write your password: ");
            existingUser.setPassword(valid.validInput());

            System.out.print("write your gameName: ");
            existingUser.setGamename(valid.validInput());

            // Save the updated user to the database
            Main.iuser.save(existingUser);

            System.out.println("User informationen uppdated!");
        } else {
            System.out.println("User with ID " + userIdToUpdate + " not found!");
        }
    }

    public void createUser() {
        String userName;
        String gameName;
        String password = null;
        boolean trueName = true;

        System.out.print("Enter userName: ");
        userName = valid.validInput();
        Optional<User> names = Main.iuser.findByUsername(userName);
        if (names.isPresent()) {
            System.out.println("UserName is taken!");
            return;

        }
        System.out.print("Enter gameName: ");
        gameName = valid.validInput();
        Optional<User> name = Main.iuser.findByGamename(gameName);
        if (name.isPresent()) {
            System.out.println("gameName is taken!");
            return;
        } else {
            System.out.print("Enter password: ");
            password = valid.validInput();
        }
        User user1 = new User(userName, password, gameName);
        Main.iuser.save(user1);
        System.out.println("User " + userName + " has been added.");
    }

    public long login() {
        User user = new User();
        int attempts = 3;

        do {
            System.out.print("Enter Username: ");
            String username = valid.validInput();

            System.out.print("Enter Password: ");
            String password = valid.validInput();

            long foundId = login.authenticateUser(username, password);

            if (foundId >= 0) {
                System.out.println("Your now logged in: " + username);
                return foundId;
            } else {
                attempts--;
                System.out.println("Attempts left: " + attempts);
                System.out.println("Login failed. Invalid username or password.");
            }

        } while (attempts != 0);

        return -1;
    }
}
