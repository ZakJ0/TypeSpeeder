/*Emanuel sleyman, Zakaria jaohari
2024-02-08
*/

package se.ju23.typespeeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class Game implements CommandLineRunner {

    static String[] words = {"batman", "corn", "bike", "hund", "Skola", "dator", "Lax", "Skatt", "President", "lång", "Kort", "apple", "sour", "Ulf", "Oskar"};

    @Override
    public void run(String... args) throws Exception {

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
                randomIndex = randomWords.nextInt(words.length); // Generate random index
            } while (selectedIndexes.contains(randomIndex)); // Check if index already selected

            selectedIndexes.add(randomIndex); // Add selected index to the set

            System.out.print(words[randomIndex] + " "); // Print the word at the selected index
        }
        System.out.println();
        double start = LocalTime.now().toNanoOfDay();
        Scanner scan = new Scanner(System.in);
        String typedWords = scan.nextLine();
        double end = LocalTime.now().toNanoOfDay();

        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;
        System.out.println(seconds + " Seconds");

        String[] incorrectWordsArr = typedWords.split(" ");
        Set<String> alreadyCounted = new HashSet<>();
        int incorrectCount = 0;
        for (int i = 0; i < Math.min(words.length, incorrectWordsArr.length); i++) {
            if (words[i].equalsIgnoreCase(incorrectWordsArr[i]) && !alreadyCounted.contains(incorrectWordsArr[i])) {
                incorrectCount++;
                alreadyCounted.add(incorrectWordsArr[i]);
            }
        }
        System.out.println("Number of incorrect words typed " + incorrectCount);
        int numChars = typedWords.length();
        int wpm = (int) (((double) (numChars / 5) / seconds) * 60);

        System.out.println("your wpm " + wpm + "!");

    }
}

