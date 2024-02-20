/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-16
 */
package se.ju23.typespeeder;

import java.time.LocalTime;
import java.util.*;

public class Challenge {
    public static String[] words = {"water","house","hus","kom","look","sir","hear",
            "se","kolla","bil","bild","fodral","glasögon","ferrari","adidas","batman",
            "corn", "bike", "hund", "Skola", "dator", "Lax", "Skatt", "President", "lång",
            "Kort", "apple", "sour", "Ulf", "Oskar"};

    public void startChallenge() {
        lettersToType();
        String typedWords = getRandomInput(); // Generate random input for testing
        calculateTypingSpeed(typedWords);
    }

    public void lettersToType() {
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
    }

    private String getRandomInput() {
        Random random = new Random();
        int numWords = random.nextInt(5) + 5; // Randomly choose between 5 to 10 words
        StringBuilder input = new StringBuilder();

        for (int i = 0; i < numWords; i++) {
            int wordIndex = random.nextInt(words.length);
            input.append(words[wordIndex]).append(" ");
        }

        return input.toString().trim();
    }

    private void calculateTypingSpeed(String typedWords) {
        double start = LocalTime.now().toNanoOfDay();

        String[] typedWordsArr = typedWords.split(" ");
        int correctTypedWords = 0;
        int totalWords = typedWordsArr.length;

        for (String typedWord : typedWordsArr) {
            if (Arrays.asList(words).contains(typedWord)) {
                correctTypedWords++;
            }
        }

        double end = LocalTime.now().toNanoOfDay();
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;

        int numChars = typedWords.replaceAll("\\s+", "").length(); // Counting total characters without spaces
        int wpm = ((int) (((double) (numChars / 5) / seconds) * 60));// Adjusted WPM calculation

        displayResults(correctTypedWords, totalWords, wpm);
    }

    private void displayResults(int correctTypedWords, int totalWords, int wpm) {
        int incorrectTypedWords = totalWords - correctTypedWords;

        System.out.println("Correct words typed: " + correctTypedWords);
        System.out.println("Incorrect words typed: " + incorrectTypedWords);
        System.out.println("Your WPM = " + wpm);
        System.out.println();
    }
}
