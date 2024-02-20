package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.Leaderboard;
import se.ju23.typespeeder.databas.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameStatistics {
    private List<Leaderboard> leaderboards;
    User user= new User();

    public GameStatistics(List<Leaderboard> leaderboards) {
        this.leaderboards = leaderboards;
    }
    public void displayGameStatistics() {
        if (leaderboards == null) {
            System.out.println("No leaderboard data available.");
            return;
        }
        double totalSeconds = 0;
        int totalMostRightWords = 0;
        int totalMostWordsInOrder = 0;
        double totalAccuracyPercentage = 0;
        int totalWpm = 0;
        int numEntries = 0; // Count the total number of entries

        for (Leaderboard leaderboard : leaderboards) {
            try {
                Double speed = leaderboard.getSpeed();
                if (speed != null) {
                    totalSeconds += speed;
                    totalMostRightWords += leaderboard.getMostrights();
                    totalMostWordsInOrder += leaderboard.getMostrightInorder();
                    totalAccuracyPercentage +=  leaderboard.getAverage();
                    // Assuming that "resultcol" stores the WPM as an integer value
                    totalWpm += Integer.parseInt(leaderboard.getResultcol());
                    numEntries++; // Increment the count for this user
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("Error parsing integer from result column.", e);
            } catch (NullPointerException e) {
                System.err.println("NullPointerException caught while processing leaderboard data: " + e.getMessage());
                // Log the error or handle it as per your requirement
            }
        }

        if (numEntries == 0) {
            System.out.println("No leaderboard data available.");
            return;
        }

        double averageSeconds = totalSeconds / numEntries;
        int averageMostRightWords = totalMostRightWords / numEntries;
        int averageMostWordsInOrder = totalMostWordsInOrder / numEntries;
        double averageAccuracyPercentage = totalAccuracyPercentage / numEntries;
        int averageWpm = totalWpm / numEntries;

         // Convert to percentage
        averageWpm /= 2; // Assuming WPM is stored as the number of words per minute * 2 (just an example)

        // Assuming you have a reference to the User class in the Leaderboard class
        System.out.print("Enter your User ID: ");
        long userId = Main.input.nextLong();
        Optional<User> optionalUser = Main.iuser.findById(userId);
        user = optionalUser.orElse(null);
        if (user == null) {
            System.out.println("Error: User with ID " + userId + " not found.");
            return;
        }

        String gameName = user.getGamename(); // Assuming all entries have the same game name
         // Assuming all entries have the same user id

        System.out.println("Game Name: " + gameName);
        System.out.println("User ID: " + userId);

        System.out.println("------ Average Game Statistics ------");
        System.out.println("Average Speed: " + averageSeconds + " seconds");
        System.out.println("Average Correct words typed: " + averageMostRightWords);
        System.out.println("Average Correct words typed in order: " + averageMostWordsInOrder);
        System.out.println("Average Accuracy: " + averageAccuracyPercentage + "%");
        System.out.println("Average Words per minute (WPM): " + averageWpm);
        System.out.println("-------------------------------------");
    }



}


