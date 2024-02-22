package se.ju23.typespeeder.logic;
/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-14
 */

import org.springframework.stereotype.Component;
import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.databas.Leaderboard;
import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.io.ConsoleColor;
import se.ju23.typespeeder.io.Valid;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class Game {

    private int Easy = 1;
    private int Medium = 2;
    private int Hard = 3;

    Scanner input = new Scanner(System.in);
    User user = new User();
    XPlevel xPlevel = new XPlevel();
    Valid valid = new Valid();

    public Game() {

    }

    public void playGame() {
        try {
            System.out.print("Enter your gameName: " + "\n");
            String gameName = input.nextLine();
            Optional<User> optionalUser = Main.iuser.findByGamename(gameName);
            user = optionalUser.orElse(null);

            if (user == null) {
                System.out.println("Error: User with gameName:" + gameName + " not found.");
                return;
            }

            System.out.println("Choose difficulty");
            System.out.println("1. Easy" + "\n" + "2. Medium" + "\n" + "3. Hard");
            System.out.print(">");

                int chosenDifficulty;
                chosenDifficulty = valid.readIntOnly();

                String chosenDiff;
                if (chosenDifficulty == Easy)
                    chosenDiff = "Easy";
                else if (chosenDifficulty == Medium) {
                    chosenDiff = "Medium";
                } else if (chosenDifficulty == Hard) {
                    chosenDiff = "Hard";
                } else {
                    System.out.println("Invalid choice. Please choose 1, 2 or 3");
                    return;
                }


            System.out.println("Enter taskID to play");
            List<Gametask> allTypes = Main.igametask.findGametaskByTaskType(chosenDifficulty);
            for (int i = 0; i < allTypes.size(); i++) {
                System.out.print("Language=" + allTypes.get(i).getLanguage() + " ");
                System.out.print("Task=" + allTypes.get(i).getTaskId() + " ");
                System.out.println("Name=" + allTypes.get(i).getName());
            }
            System.out.println();


            String chosenLanguage;
            int languageChoice;
            System.out.println("Choose your preferred language:");
            System.out.println("1. English");
            System.out.println("2. Svenska");
            System.out.print(">");
            languageChoice = valid.readIntOnly();
            if (languageChoice == 1) {
                chosenLanguage = "engelska";
            } else if (languageChoice == 2) {
                chosenLanguage = "svenska";
            } else {
                System.out.println("Invalid choice. Please choose 1 for English or 2 for Svenska.");
                return;
            }

            List<Gametask> taskType = new ArrayList<>();
            for (Gametask task : allTypes) {
                if (task.getLanguage().equals(chosenLanguage)) {
                    taskType.add(task);
                }
            }
            if (taskType.isEmpty()) {
                System.out.println("No available task for the choosen language sorry");
                return;
            }

            for (Gametask tasks : taskType) {
                System.out.println(chosenLanguage + " " + tasks.getName() + " taskID ->" + tasks.getTaskId());
            }


            long taskId = 0;
            Gametask gametask = null;

                System.out.print("Enter Task ID: ");
                taskId = valid.readLongOnly();
                Optional<Gametask> optionalGametask = Main.igametask.findById(taskId);
                gametask = optionalGametask.orElse(null);

                if (gametask == null) {
                    System.out.println("Error: Gametask with ID " + taskId + " not found.");
                    return;
                }

                if (!Objects.equals(chosenLanguage, gametask.getLanguage())) {
                    System.out.println("Error: Chosen language does not match the task language.");
                    return;
                }


            countdown();

            System.out.println(user.getGamename() + " Your GameLevel: " + user.getGamelevel());

            System.out.println(ConsoleColor.LIGHT_BLUE + gametask.getSolution());


            double start = LocalTime.now().toNanoOfDay();

            System.out.println(ConsoleColor.RESET);
            String typedWords = valid.validInput();
            double end = LocalTime.now().toNanoOfDay();

            double elapsedTime = end - start;
            double seconds = (elapsedTime / 1000000000.0);
            System.out.println(seconds + " Seconds");

            String[] solution = gametask.getSolution().split(" ");
            String[] typedWordsArr = typedWords.split(" ");
            int[] accuracyInfo = calculateAccuracy(solution, typedWordsArr);
            System.out.println(ConsoleColor.RED);
            int correctTypedWords = accuracyInfo[0];
            int incorrectTypedWords = accuracyInfo[1];
            int mostWordsInOrder = accuracyInfo[2];

            printResults(correctTypedWords, incorrectTypedWords, typedWords, user, mostWordsInOrder, calculateAccuracyPercentage(correctTypedWords, solution.length));
            System.out.println(user.getGamename() + ": your wpm:" + calculateWpm(typedWords, seconds) + "!");

            int saveXp = xPlevel.levelUp(user, calculateAccuracyPercentage(correctTypedWords, solution.length));
            System.out.println();
            System.out.println(ConsoleColor.RESET);
            Attempt newAttempt = new Attempt(user.getUserid(), taskId, calculateWpm(typedWords, seconds), Timestamp.valueOf(LocalDateTime.now()), gameName);
            newAttempt.setGametaskByTaskId(gametask);
            newAttempt.setUserByUserId(user);
            Main.attemptRepo.save(newAttempt);

            Leaderboard newLeaderboard = new Leaderboard(calculateAccuracyPercentage(correctTypedWords, solution.length), calculateWpm(typedWords, seconds), user.getUserid(), seconds, correctTypedWords, mostWordsInOrder);
            newLeaderboard.setUserByPlayerid(user);
            Main.leaderboard.save(newLeaderboard);
            user.setXp(user.getXp() + saveXp);
            Main.iuser.save(user);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void countdown() throws InterruptedException {
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println();
        System.out.println();
    }

    private int[] calculateAccuracy(String[] solution, String[] typedWordsArr) {
        int correctTypedWords = 0;
        int incorrectTypedWords = 0;
        int mostWordsInOrder = findMostAccurateWordsIndices(String.join(" ", typedWordsArr), solution);

        for (String typedW : typedWordsArr) {
            if (Arrays.asList(solution).contains(typedW)) {
                correctTypedWords++;
            } else {
                incorrectTypedWords++;
            }
        }
        return new int[]{correctTypedWords, incorrectTypedWords, mostWordsInOrder};
    }

    private int calculateAccuracyPercentage(int correctTypedWords, int totalWords) {
        return (int) (((double) correctTypedWords / totalWords) * 100);
    }

    private String calculateWpm(String typedWords, double seconds) {
        int numChars = typedWords.length();
        return String.valueOf((int) (((double) (numChars / 5) / seconds) * 60));
    }

    private void printResults(int correctTypedWords, int incorrectTypedWords, String typedWords, User user, int mostWordsInOrder, int accuracyPercentage) {
        System.out.println("Correct words typed: " + correctTypedWords);
        System.out.println("Incorrect words typed: " + incorrectTypedWords);
        System.out.println("Correct words typed in order: " + mostWordsInOrder);
        System.out.println("Accuracy: " + accuracyPercentage + "%");
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




