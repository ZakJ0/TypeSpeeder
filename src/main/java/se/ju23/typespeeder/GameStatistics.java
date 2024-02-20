package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.Leaderboard;
import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.io.ConsoleColor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GameStatistics {
    private List<Leaderboard> leaderboards;

    public GameStatistics(List<Leaderboard> leaderboards) {
        this.leaderboards = leaderboards;
    }

    public void displayGameStatistics() {
        if (leaderboards == null) {
            System.out.println("No leaderboard data available.");
            return;
        }
        List<User> players = Main.iuser.findAll();

        for (int i = 0; i < players.size(); i++) {
            double totalSeconds = 0;
            int totalMostRightWords = 0;
            int totalMostWordsInOrder = 0;
            double totalAccuracyPercentage = 0;
            int totalWpm = 0;
            int numEntries = 0; // Count the total number of entries
            long id = players.get(i).getUserid();
            List<Leaderboard> lead = Main.leaderboard.findByPlayerid(id);
            for (int j = 0; j < lead.size(); j++) {
                totalSeconds += lead.get(j).getSpeed();
                totalMostRightWords += lead.get(j).getMostrights();
                totalMostWordsInOrder += lead.get(j).getMostrightInorder();
                totalAccuracyPercentage += lead.get(j).getAverage();
                totalWpm += Integer.parseInt(lead.get(j).getResultcol());
                numEntries++;
            }
            double averageSeconds = totalSeconds / numEntries;
            int averageMostRightWords = totalMostRightWords / numEntries;
            int averageMostWordsInOrder = totalMostWordsInOrder / numEntries;
            double averageAccuracyPercentage = totalAccuracyPercentage / numEntries;
            int averageWpm = totalWpm / numEntries;
            System.out.println(ConsoleColor.LIGHT_BLUE+"Alias: " + players.get(i).getGamename());

            System.out.println("------ Average Game Statistics ------");
            System.out.println("Average Speed: " + averageSeconds + " seconds");
            System.out.println("Average Correct words typed: " + averageMostRightWords);
            System.out.println("Average Correct words typed in order: " + averageMostWordsInOrder);
            System.out.println("Average Accuracy: " + averageAccuracyPercentage + "%");
            System.out.println("Average Words per minute (WPM): " + averageWpm);
            System.out.println(ConsoleColor.RESET+"-------------------------------------");
        }
    }
}
