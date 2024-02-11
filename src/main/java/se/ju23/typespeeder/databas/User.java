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
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Attempt> attemptsByUserid;
    @OneToMany(mappedBy = "userByPlayerid")
    private Collection<Leaderboard> leaderboardsByUserid;


    public User(String userName, String password, String gamename) {
        this.username = userName;
        this.password = password;
        this.gamename = gamename;
    }

    public User() {

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
        System.out.println("Updatera user information");
        System.out.print("Skriv in userID för att uppdatera: ");
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

        System.out.print("Ange userName: ");
        userName = validInput();
        Optional<User> names = Main.iuser.findByUsername(userName);
        if (names.isPresent()) {
            System.out.println("Användarnamnet är upptaget!");
            return;

        }
        System.out.print("Ange gameName: ");
        gameName = validInput();
        Optional<User> name = Main.iuser.findByGamename(gameName);
        if (name.isPresent()) {
            System.out.println("Användarnamnet är upptaget!");
            return;
        } else {
            System.out.print("Ange password: ");
            password = validInput();
        }
        User user1 = new User(userName, password, gameName);
        Main.iuser.save(user1);
        System.out.println("Användaren " + userName + " har lagts till.");
    }

    public long readUsersFromDatabase() {
        int attempts = 3;

        do {
            System.out.print("Enter username: ");
            String username = validInput();

            System.out.print("Enter password: ");
            String password = validInput();

            long foundId = authenticateUser(username, password);

            if (foundId >= 0) {
                System.out.println("Logged in as: " + username.toLowerCase());
                return foundId;
            } else {
                attempts--;
                System.out.println("Attempts left: " + attempts);
                System.out.println("Login failed. Invalid username or password.");
            }

        } while (attempts != 0);

        return -1; // Indicate unsuccessful login after all attempts.
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

    public Timestamp getCurrentTime() {
        return (new Timestamp(System.currentTimeMillis()));
    }
/*
    public void deleteUser() {
        System.out.println("Vilken användare vill du ta bort med hjälp av userId");
        System.out.println("Ange userID");
        long userId = readLongOnly();
        if (iUser.existsById(userId)) {
            iUser.deleteAllById(Collections.singleton((long) userId));
            System.out.println("användare med id: " + userId + " har tagits bort");
        } else {
            System.out.println("userId existerar inte");
        }
    }

 */

    public void showJavaLevels() {
        List<User> levels = Main.iuser.findAll();
        for (User a : levels) {
            System.out.println("Användarnamn: " + a.getUsername() +
                    "\nJava-nivå: " + a.getGamelevel() +
                    "\nAnvändar-id: " + a.getUserid() + "\n-----------------------");
        }
    }

    public long getJavaLevel(long userid) {
        long levl = 0;
        Optional<User> getlevel = Main.iuser.findById(userid);
        if (getlevel.isPresent()) {
            User lev = getlevel.get();
            levl = lev.getGamelevel();
        } else {
            return levl;
        }
        return levl;
    }

    public String validInput() {
        String inputString;
        while (true) {
            inputString = Main.input.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Du måste ange något!");
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
                System.err.println("Ogiltig inmatning. Vänligen skriv in ett heltal: ");
            }
        }
    }

            public int readIntOnly () {
                while (true) {
                    try {
                        int intOnly = Integer.parseInt(validInput());
                        return intOnly;
                    } catch (NumberFormatException e) {
                        System.err.println(e + " Vänligen skriv in ett heltal:");
                    }
                }
            }
        }

