/*
Emanuel sleyman, Zakaria Jaouhari
2024-02-17
*/
package se.ju23.typespeeder.logic;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Games {

    public Games(){

    }
    public static String[] words = {"water","house","hus","kom","look","sir","hear",
            "se","kolla","bil","bild","fodral","glasögon","ferrari","adidas","batman",
            "corn", "bike", "hund", "Skola", "dator", "Lax", "Skatt", "President", "lång",
            "Kort", "apple", "sour", "Ulf", "Oskar"};
    public void warmUp(){
        try {
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
            System.out.println("Your WPM " +"="+ wpm + "!"+ "\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void countUppercaseWordsGame() {
        try {
            System.out.println("Get ready to count uppercase words!");
            System.out.println("3");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("2");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("1");
            TimeUnit.SECONDS.sleep(1);

            Random randomWords = new Random();
            Set<Integer> selectedIndexes = new HashSet<>();
            int totalWords = 10;
            String[] words = {"Hello", "WORLD", "upPERCASE", "game", "WORD", "Java", "ComPuter",
                    "player", "apple", "UP","Left","riGht","YoU","kNow"};

            for (int i = 0; i < totalWords; i++) {
                int randomIndex;
                do {
                    randomIndex = randomWords.nextInt(words.length);
                } while (selectedIndexes.contains(randomIndex));

                selectedIndexes.add(randomIndex);

                System.out.print(words[randomIndex] + " ");
            }
            System.out.println();
            Scanner scan = new Scanner(System.in);
            String typedWords = scan.nextLine();

            int countUppercaseWords = 0;

            String[] typedWordsArr = typedWords.split(" ");
            for (String typedWord : typedWordsArr) {
                if (typedWord.equals(typedWord.toUpperCase())) {
                    countUppercaseWords++;
                }
            }

            System.out.println("Number of uppercase words typed: " + countUppercaseWords);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
