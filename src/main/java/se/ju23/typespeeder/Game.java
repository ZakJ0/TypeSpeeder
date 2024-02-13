/*
Emanuel sleyman
2024-02-08
*/
package se.ju23.typespeeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.ju23.typespeeder.logic.Gametask;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class Game  {
    Gametask gametask;
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
            language();
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
            int wpm = (int) (((double) (numChars / 5) / seconds) * 60);

            System.out.println("your wpm " + wpm + "!");
        }
        public void language(){
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to choose a language
            System.out.println("Choose a language: ");
            System.out.println("1. English");
            System.out.println("2. Svenska");
            System.out.print("Enter the number corresponding to your choice: ");
            int languageChoice = scanner.nextInt();
            String language;
            switch (languageChoice) {
                case 1:
                    language = "English";
                    break;
                case 2:
                    language = "Svenska";
                    break;
                default:
                    System.out.println("Invalid choice, defaulting to English.");
                    language = "English";
            }

            // Fetch the game task based on the selected language
            Gametask gameTask = Gametask.getGameTaskByLanguage(language);

            // Use the solution fetched from the database
            String solution = gameTask.getSolution();
            String[] words = solution.split("\\s+");
            System.out.println(words.toString());

            // Rest of your game logic...
        }


    }


