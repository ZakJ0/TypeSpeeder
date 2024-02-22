/*
Emanuel sleyman
2024-02-17
*/
package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.io.ConsoleColor;
import se.ju23.typespeeder.io.Valid;

import java.io.Console;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Games {
    private Valid valid= new Valid();

    public Games(){

    }

    public static String[] words = {"water","house","hus","kom","look","sir","hear",
            "se","kolla","bil","bild","fodral","glasögon","ferrari","adidas","batman",
            "corn", "bike", "hund", "Skola", "dator", "Lax", "Skatt", "President", "lång",
            "Kort", "apple", "sour", "Ulf", "Oskar"};

    public void warmUp(){
        try {
            System.out.println(ConsoleColor.BLUE+"3");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("2");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("1"+ ConsoleColor.RESET);
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

                String word = words[randomIndex];
                if (word.contains("a")) {
                    System.out.print(ConsoleColor.LIGHT_PINK + word + " " + ConsoleColor.RESET);
                }
                else if (word.contains("b") || word.contains("P") || word.contains("s")) {
                    System.out.print(ConsoleColor.LIGHT_BLUE + word + " " + ConsoleColor.RESET);
                }
                else if (word.contains("o")) {
                    System.out.print(ConsoleColor.LIGHT_GREEN + word + " " + ConsoleColor.RESET);
                }
                else if (word.contains("H") || word.contains("y") || word.contains("w")) {
                    System.out.print(ConsoleColor.RED + word + " " + ConsoleColor.RESET);
                }else {
                    System.out.print(word + " ");
                }
            }
            System.out.println();

            double start = LocalTime.now().toNanoOfDay();
            String typedWords = valid.validInput();
            double end = LocalTime.now().toNanoOfDay();

            double elapsedTime = end - start;
            double seconds = elapsedTime / 1000000000.0;
            System.out.println(seconds + " Seconds");

            String[] typedWordsArr = typedWords.split(" ");
            int incorrectTypedWords = 0;
            int correctTypedWords = 0;

            for (String typedWord : typedWordsArr) {
                if (Arrays.asList(words).contains(typedWord)) {
                    correctTypedWords++;
                } else {
                    incorrectTypedWords++;
                }
            }

            System.out.println(ConsoleColor.LIGHT_BLUE+"Correct words typed: " + correctTypedWords);
            System.out.println("Incorrect words typed: " + incorrectTypedWords);
            System.out.println(Arrays.toString(typedWordsArr)); // Comparison reasons


            int numChars = typedWords.length();
            String wpm = String.valueOf((int) (((double) (numChars / 5) / seconds) * 60));
            System.out.println("Your WPM " +"="+ wpm + "!"+ "\n"+ConsoleColor.RESET );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void countUppercaseWordsGame() {
        try {
            System.out.println(ConsoleColor.BLUE+"Get ready to count words with uppercase letters!");
            System.out.println("3");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("2");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("1"+ ConsoleColor.RESET);
            TimeUnit.SECONDS.sleep(1);

            Random randomWords = new Random();
            Set<Integer> selectedIndexes = new HashSet<>();
            int totalWords = 10;
            String[] words = {"Hello", "WORLD", "upPERCASE", "game", "WORD", "Java", "ComPuter",
                    "player", "apple", "UP", "Left", "riGht", "YoU", "kNow", "hej","Fell", "asTro", "trOn","fail","snail",
                    "Book", "PAGE", "sKy", "FiSH", "gRaSS", "tRee", "cLoUd", "moOn", "sUn", "stAr", "wAtEr", "caR", "PlaNe",
                    "hiLl", "mOuNtAiN", "vAlLeY", "oCeAn", "foReSt", "DesErT", "sAnd", "apple", "banana", "carrot", "dog", "elephant", "giraffe", "hamster",
                    "iguana", "jellyfish", "kiwi", "lemon", "mango", "noodle", "octopus", "peanut", "quinoa", "raspberry"};

            int uppercaseWordsCount = 0;
            System.out.println(ConsoleColor.LIGHT_PINK + "Type the number of words with uppercase letters:"+ConsoleColor.RESET+ "\n");


            for (int i = 0; i < totalWords; i++) {
                int randomIndex;
                do {
                    randomIndex = randomWords.nextInt(words.length);
                } while (selectedIndexes.contains(randomIndex));

                selectedIndexes.add(randomIndex);

                System.out.print(ConsoleColor.LIGHT_BLUE+words[randomIndex] + " ");

                if (words[randomIndex].matches(".*[A-Z]+.*")) {
                    uppercaseWordsCount++;
                }
            }
            System.out.println(ConsoleColor.RESET);
            int userAnswer = valid.readIntOnly();
            if (userAnswer == uppercaseWordsCount) {
                System.out.println(ConsoleColor.LIGHT_PINK+"Correct! The number of words with uppercase letters is " + uppercaseWordsCount+ ConsoleColor.RESET);
            } else {

                System.out.println(ConsoleColor.RED+"Incorrect! The number of words with uppercase letters is " + uppercaseWordsCount+ ConsoleColor.RESET);

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
