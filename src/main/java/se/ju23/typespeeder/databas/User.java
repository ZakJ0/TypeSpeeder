/*Zakaria Jaouhari,Emanuel Sleyman
30-01-24
zakaria.jaouhari@iths.se*/
package se.ju23.typespeeder.databas;

import jakarta.persistence.*;
import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.logic.Attempt;

import java.sql.*;
import java.util.*;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid", nullable = false)
    private long userid;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "gamelevel", nullable = false)
    private int gamelevel;
    @Basic
    @Column(name = "gamename", nullable = false, length = 45)
    private String gamename;

    @Basic
    @Column(name = "xp",nullable=false)
    private int xp;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Attempt> attemptsByUserid;
    @OneToMany(mappedBy = "userByPlayerid")
    private Collection<Leaderboard> leaderboardsByUserid;

    public User(int xp) {
        this.xp = xp;
    }

    public User(String userName, String password, String gamename) {
        this.username = userName;
        this.password = password;
        this.gamename = gamename;
    }

    public User() {
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGamelevel() {
        return gamelevel;
    }

    public void setGamelevel(int gamelevel) {
        this.gamelevel = gamelevel;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid == user.userid && gamelevel == user.gamelevel && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(gamename, user.gamename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, password, gamelevel, gamename);
    }

    public Collection<Attempt> getAttemptsByUserid() {
        return attemptsByUserid;
    }

    public void setAttemptsByUserid(Collection<Attempt> attemptsByUserid) {
        this.attemptsByUserid = attemptsByUserid;
    }

    public Collection<Leaderboard> getLeaderboardsByUserid() {
        return leaderboardsByUserid;
    }

    public void setLeaderboardsByUserid(Collection<Leaderboard> leaderboardsByUserid) {
        this.leaderboardsByUserid = leaderboardsByUserid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gamelevel=" + gamelevel +
                ", gamename='" + gamename + '\'' +
                '}';
    }

    public void updateUserInDatabase() {
        System.out.println("Update user information");
        System.out.print("Write  userID to uppdate: ");
        long userIdToUpdate = readLongOnly();

        Optional<User> optionalUser = Main.iuser.findById(userIdToUpdate);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            System.out.print("write your username: ");
            existingUser.setUsername(validInput());

            System.out.print("write your password: ");
            existingUser.setPassword(validInput());

            System.out.print("write your gameName: ");
            existingUser.setGamename(validInput());

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
        userName = validInput();
        Optional<User> names = Main.iuser.findByUsername(userName);
        if (names.isPresent()) {
            System.out.println("UserName is taken!");
            return;

        }
        System.out.print("Enter gameName: ");
        gameName = validInput();
        Optional<User> name = Main.iuser.findByGamename(gameName);
        if (name.isPresent()) {
            System.out.println("gameName is taken!");
            return;
        } else {
            System.out.print("Enter password: ");
            password = validInput();
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
            String username = validInput();

            System.out.print("Enter Password: ");
            String password = validInput();

            long foundId = authenticateUser(username, password);

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

    public long authenticateUser(String username, String password) {
        // Connect to the database and retrieve user information
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/typespeeder", "tester", "Java1234")) {
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



    public String validInput() {
        String inputString;
        while (true) {
            inputString = Main.input.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Wrong input. You have to actually write something!");
            } else {
                return inputString;
            }
        }
    }

    public long readLongOnly() {
        while (true) {
            try {
                return Long.parseLong(validInput());
            } catch (NumberFormatException e) {
                System.err.println("wrong input. Please enter an integer or double with ,: ");
            }
        }
    }

    public int readIntOnly() {
        while (true) {
            try {
                int intOnly = Integer.parseInt(validInput());
                return intOnly;
            } catch (NumberFormatException e) {
                System.err.println(e + "Wrong input. Please enter an integer:");
            }
        }
    }
    public int levelUp(User user, double accuracyPercentage) {
        int xpGained = 0;
        if (accuracyPercentage >= 70) {
            // Gain XP
            xpGained = 5; // Adjust the XP gained as per your requirements
            user.setXp(user.getXp() + xpGained); // Update user's XP
            System.out.println("Congratulations! You gained " + xpGained*2 + " XP.");
        } else {
            // Lose XP (if not already at level 1)
            if (user.getXp() > 5) {
                xpGained = -5; // Adjust the XP lost as per your requirements
                user.setXp(Math.max(0, user.getXp() + xpGained)); // Update user's XP
                System.out.println("You lost " + -xpGained*2 + " XP.");
            } else {
                System.out.println("You are already at the lowest level and cannot lose further XP.");
            }
        }

        // Check for level up
        while (user.getXp() >= 99) {
            // Level up
            user.setGamelevel(user.getGamelevel() + 1);
            user.setXp(user.getXp() - 99);
            System.out.println("Congratulations! You leveled up to level " + user.getGamelevel() + ".");
        }

        return xpGained;
    }
}

