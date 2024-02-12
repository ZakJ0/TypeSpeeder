/*
Emanuel sleyman
Zakaria Jaouhari
2024-02-08
*/
package se.ju23.typespeeder.logic;

import org.springframework.stereotype.Component;
import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.databas.User;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class Game {

    public Game() {

    }

    public static String[] words = {
            "water","house","hus","kom","look","sir","hear",
            "se","kolla","bil","bild","fodral","glasögon","ferrari","adidas","batman",
            "corn", "bike", "hund", "Skola", "dator", "Lax", "Skatt", "President", "lång",
            "Kort", "apple", "sour", "Ulf", "Oskar","lamborghini","kalle","hej","java","nobell","vem","som",
            "maggot","faggot","mus","tratt","it","program","programmering"
    };


    public void playGame() throws InterruptedException {

        Long nextAttemptId = Main.attemptRepo.getNextAttemptId();

        System.out.print("Enter User ID: ");
        long userId = Main.input.nextLong();
        Optional<User> optionalUser = Main.iuser.findById(userId);
        User user = optionalUser.orElse(null);

        if (user == null) {
            System.out.println("Error: User with ID " + userId + " not found.");
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

        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        Random randomWords = new Random();
        Set<Integer> selectedIndexes = new HashSet<>();
        int totalWords = 10;

        for (int i = 0; i < totalWords; i++) {
            int randomIndex;
            do {
                randomIndex = randomWords.nextInt(words.length);
            } while (selectedIndexes.contains(randomIndex));

            selectedIndexes.add(randomIndex);

            System.out.print(words[randomIndex] + " ");
        }
        System.out.println();
        double start = LocalTime.now().toNanoOfDay();
        Scanner scan = new Scanner(System.in);
        String typedWords = scan.nextLine();
        double end = LocalTime.now().toNanoOfDay();

        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;
        System.out.println(seconds + " Seconds");

        String[] typedWordsArr = typedWords.split(" ");
        Set<String> alreadyCounted = new HashSet<>();
        int incorrectTypedWords = 0;
        int correctTypedWords = 0;

        for (String typedWord : typedWordsArr) {
            if (Arrays.asList(words).contains(typedWord)) {
                correctTypedWords++;
            } else {
                incorrectTypedWords++;
            }
        }

        System.out.println("Correct words typed: " + correctTypedWords);
        System.out.println("Incorrect words typed: " + incorrectTypedWords);
        System.out.println(Arrays.toString(typedWordsArr)); // Comparison reasons


        int numChars = typedWords.length();
        String wpm = String.valueOf((int) (((double) (numChars / 5) / seconds) * 60));
        System.out.println(user.getUsername()+ " Your WPM " +"= "+ wpm + "!"+ "\n");

        Attempt newAttempt = new Attempt(nextAttemptId, userId, taskId, wpm, Timestamp.valueOf(LocalDateTime.now()));
        newAttempt.setGametaskByTaskId(gametask);
        newAttempt.setUserByUserId(user);
        // Save the new Attempt entity
        Main.attemptRepo.save(newAttempt);




    }

}


