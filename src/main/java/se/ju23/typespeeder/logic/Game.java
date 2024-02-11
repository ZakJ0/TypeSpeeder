/*
Emanuel sleyman
2024-02-08
*/
package se.ju23.typespeeder.logic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.logic.AttemptRepo;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class Game  {


    public Game(){

    }

    public static String[] words = {"batman", "corn", "bike", "hund", "Skola", "dator", "Lax", "Skatt", "President", "lång", "Kort", "apple", "sour", "Ulf", "Oskar"};


    public void playGame() throws InterruptedException {

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

            System.out.println("Correct words typed: "+ correctTypedWords);
            System.out.println("Incorrect words typed: "+ incorrectTypedWords);
            System.out.println(Arrays.toString(typedWordsArr)); // Comparison reasons


            int numChars = typedWords.length();
            String wpm = String.valueOf((int) (((double) (numChars / 5) / seconds) * 60));

            System.out.println("your wpm " + wpm + "!");

        Attempt attempt1 = new Attempt(1L, 1L, 1L, wpm);

        // Set the endTime attribute to the current timestamp
        attempt1.setEndTime(new Timestamp(System.currentTimeMillis()));

        Main.attemptRepo.save(attempt1);

        }
    }


