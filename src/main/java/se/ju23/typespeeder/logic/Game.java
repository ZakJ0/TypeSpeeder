/*
Emanuel sleyman
2024-02-08
*/
package se.ju23.typespeeder.logic;

import org.springframework.stereotype.Component;
import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.databas.Leaderboard;
import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.databas.iUser;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class Game {
    iGameTask gameTask;
    User user;
    //XPlevel xp = new XPlevel();

    public Game() {

    }


    public void playGame() throws InterruptedException {
        System.out.print("Enter User ID: ");
        long userId = Main.input.nextLong();
        Optional<User> optionalUser = Main.iuser.findById(userId);
        user = optionalUser.orElse(null);

        if (user == null) {
            System.out.println("Error: User with ID " + userId + " not found.");
            return;
        }

// Prompt the player to choose their preferred language
        System.out.println("Choose your preferred language:");
        System.out.println("1. English");
        System.out.println("2. Svenska");

        int languageChoice = Main.input.nextInt();
        String chosenLanguage;

// Set the chosen language based on the player's input
        if (languageChoice == 1) {
            chosenLanguage = "engelska";
        } else if (languageChoice == 2) {
            chosenLanguage = "svenska";
        } else {
            System.out.println("Invalid choice. Please choose 1 for English or 2 for Svenska.");
            return;
        }

        System.out.print("Enter Task ID: ");
        long taskId = Main.input.nextLong();
        Optional<Gametask> optionalGametask = Main.igametask.findById(taskId);
        Gametask gametask = optionalGametask.orElse(null);

        if (gametask == null) {
            System.out.println("Error: Gametask with ID " + taskId + " not found.");
            return;
        }

// Check if the task's language matches the chosen language
        if (!Objects.equals(chosenLanguage, gametask.getLanguage())) {
            System.out.println("Error: Chosen language does not match the task language.");
            return;
        }

        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println();
        System.out.println(user.getGamename() + " Your GameLevel: " + user.getGamelevel());

        System.out.println(gametask.getSolution());

        System.out.println();
        double start = LocalTime.now().toNanoOfDay();
        Scanner scan = new Scanner(System.in);
        String typedWords = scan.nextLine();
        double end = LocalTime.now().toNanoOfDay();


        double elapsedTime = end - start;
        double seconds = (elapsedTime / 1000000000.0);
        System.out.println(seconds + " Seconds");

        String[] solution = gametask.getSolution().split(" ");
        String[] typedWordsArr = typedWords.split(" ");
        int incorrectTypedWords = 0;
        int correctTypedWords = 0;

        for (String typedW : typedWordsArr) {
            if (Arrays.asList(solution).contains(typedW)) {
                correctTypedWords++;
            } else {
                incorrectTypedWords++;
            }
        }

        int mostWordsInOrder = findMostAccurateWordsIndices(typedWords, solution);
        System.out.println("Correct words typed: " + correctTypedWords);
        System.out.println("Incorrect words typed: " + incorrectTypedWords);
        int numChars = typedWords.length();
        String wpm = String.valueOf((int) (((double) (numChars / 5) / seconds) * 60));
        System.out.println(user.getGamename() + " Your WPM " + "= " + wpm + "!" + "\n");

        double totalWords = solution.length;
        double countAverage = correctTypedWords / totalWords * 100;
        System.out.printf("%.2f %s %n ", countAverage, "%");
        int saveXp= user.levelUp(user,countAverage);


        Attempt newAttempt = new Attempt(userId, taskId, wpm, Timestamp.valueOf(LocalDateTime.now()));
        newAttempt.setGametaskByTaskId(gametask);
        newAttempt.setUserByUserId(user);

// Save the new Attempt entity
        Main.attemptRepo.save(newAttempt);
//creating leaderboard saves
        Leaderboard newLeaderboard = new Leaderboard(countAverage, wpm, userId, seconds, correctTypedWords, mostWordsInOrder);
        newLeaderboard.setUserByPlayerid(user);
        Main.leaderboard.save(newLeaderboard);
        user.setXp(user.getXp() + saveXp);

// Save the updated user to the database
        Main.iuser.save(user);

    }
    private int findMostAccurateWordsIndices(String typedWords, String[] solution) {
        String[] typedWordsArr = typedWords.split(" ");

        int maxCorrectTypedWords = 0;
        int currentCorrectTypedWords = 0;

        for (int i = 0; i < typedWordsArr.length; i++) {
            if (Arrays.asList(solution).contains(typedWordsArr[i])) {
                currentCorrectTypedWords++;
            } else {
                if (currentCorrectTypedWords > maxCorrectTypedWords) {
                    maxCorrectTypedWords = currentCorrectTypedWords;
                }
                currentCorrectTypedWords = 0;
            }
        }

        if (currentCorrectTypedWords > maxCorrectTypedWords) {
            maxCorrectTypedWords = currentCorrectTypedWords;
        }

        return maxCorrectTypedWords;
    }
    }




