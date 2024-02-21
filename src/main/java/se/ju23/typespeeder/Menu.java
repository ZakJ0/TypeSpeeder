/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-10
 */
package se.ju23.typespeeder;
import se.ju23.typespeeder.databas.Leaderboard;

import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.io.UserCreateUpdate;
import se.ju23.typespeeder.io.Valid;
import se.ju23.typespeeder.logic.Game;
import se.ju23.typespeeder.logic.Games;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static se.ju23.typespeeder.Main.leaderboard;

public class Menu implements MenuService{
    User user;
    Game game = new Game();
    Games games = new Games();
    GameStatistics gameStatistics;
    UserCreateUpdate u = new UserCreateUpdate();

    private String language = "svenska";
    private Valid valid= new Valid();
    UserCreateUpdate up = new UserCreateUpdate();
    public Menu() {
        this.user = new User();
    }



    public void loginMenu(){
        boolean loggedIn = false;
        System.out.println("Welcome");

        do {
            System.out.println("0. Quit");
            System.out.println("Do you have an account?/Har du ett konto?" + "\n");
            System.out.println("1. Login/Logga in");
            System.out.println("2. Create account/Skapa konto");

            System.out.print(">");
            int answer = valid.readIntOnly();
            if (answer == 1) {
                up.login();
                loggedIn = true;
            } else if (answer == 2) {
                System.out.println("Creating account, remember ID and other important account features!");
                up.createUser();
                loggedIn = true;
            } else if (answer == 0) {
                System.exit(0);
                System.out.println("Bye..");
            }
        } while (!loggedIn);
    }

    public void languageChoosing() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Välj språk (svenska/engelska):");
            String selectedLanguage="svenska";
            while (selectedLanguage.isBlank()) {
                if (input.hasNextLine()) {
                    selectedLanguage = valid.validInput().toLowerCase();
                } else {
                    System.out.println("No input detected. Please enter the language choice.");
                }
            }

            if (selectedLanguage.equals("svenska") || selectedLanguage.equals("s")) {
                System.out.println("Svenska valt.");
                language = "svenska";
            } else if (selectedLanguage.equals("engelska") || selectedLanguage.equals("e")) {
                language = "engelska";
            } else {
                System.out.println("Invalid language selection. Default language set to English.");
                language = "English";
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        }
    }

    public void start()  {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to TypeSpeeder - ");
            displayMenu();
            System.out.print("Choose an option: ");
            choice = valid.readIntOnly();
            if (choice > 6) {
                System.out.println("Du har kanppat in siffra utanför intervallet!");
            }

            switch (choice) {

                case 1 -> {
                    System.out.println("Du valde att uppdatera en User");
                    u.updateUserInDatabase();
                }

                case 2 -> {
                    System.out.println("Du valde att spela rankings spelet");
                    game.playGame();
                }

                case 3 -> {
                    System.out.println("Du valde att värma upp");
                    games.warmUp();
                }

                case 4 -> {
                    System.out.println("Du valde att spela StoraBokstäver spelet");
                    games.countUppercaseWordsGame();
                }

                case 5 -> startEnglish();

                case 6 -> {
                    List<Leaderboard> leaderboards = leaderboard.findAll();
                    if (leaderboards == null) {
                        System.out.println("Ingen rankingsLista finns.");
                        return;
                    }
                    gameStatistics = new GameStatistics(leaderboards);
                    gameStatistics.displayGameStatistics();
                }
            }
        } while (choice != 0);

        System.out.println("End program");
        System.exit(0);
    }

    public void startEnglish()  {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to TypeSpeeder - ");
            System.out.println("0. Exit");
            System.out.println("1. Update User account");
            System.out.println("2. Play Game");
            System.out.println("3. Play Alt Game/Warm up");
            System.out.println("4. Play Find UpperCase words");
            System.out.println("5. Switch to swedish");
            System.out.println("6. Show Leaderboard");
            System.out.print("Choose an option: ");
            choice = valid.readIntOnly();
            if (choice > 6) {
                System.out.println("you have entered a wrong number!");
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("You chose to update a User.");
                    u.updateUserInDatabase();
                }
                case 2 -> {
                    System.out.println("You chose to play Ranked SpeedTyping Game");
                    game.playGame();
                }
                case 3 -> {
                    System.out.println("You Chose to warmup");
                    games.warmUp();
                }
                case 4 -> {
                    System.out.println("You chose Count-Uppercase Game");
                    games.countUppercaseWordsGame();
                }
                case 5 -> start();
                case 6 -> {
                    List<Leaderboard> leaderboards = leaderboard.findAll();
                    if (leaderboards == null) {
                        System.out.println("No leaderboard data available.");
                        return;
                    }
                    gameStatistics = new GameStatistics(leaderboards);
                    gameStatistics.displayGameStatistics();
                }
            }
        } while (choice != 0);

        System.out.println("End program");
        System.exit(0);
    }

    public List<String> getMenuOptionsEng() {
        List<String> options = new ArrayList<>();
        options.add("0. End program");
        options.add("1. Update User account");
        options.add("2. Play Game");
        options.add("3. Play Alt Game/Warm up");
        options.add("4. Play Find UpperCase words ");
        options.add("5. Switch to swedish");
        return options;
    }

    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("0. Avsluta programmet");
        options.add("1. Updatera användarkonto");
        options.add("2. Spela");
        options.add("3. Spela Alt spel");
        options.add("4. Spela Hitta CapsLock orden");
        options.add("5. Byt till Engelska");
        options.add("6. Visa RankningsListan");
        return options;
    }

    public void displayMenu() {
        languageChoosing();
        List<String> menuOptions;
        if (language.equalsIgnoreCase("svenska")) {
            menuOptions = getMenuOptions();
            System.out.println("Meny Alternativ - " + language + ":");
        } else {
            menuOptions = getMenuOptionsEng();
            System.out.println("Menu Options - " + language + ":");
        }

        for (String option : menuOptions) {
            System.out.println(option);
        }

        if (menuOptions.size() < 5) {
            System.out.println("not enough with alternatives");
        }
    }

}


