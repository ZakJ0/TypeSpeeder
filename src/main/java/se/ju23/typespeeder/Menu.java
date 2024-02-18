/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-10
 */
package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.logic.Game;
import se.ju23.typespeeder.logic.Games;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu implements MenuService{
    User user;
    MenuService menuService;
    Game game = new Game();
    Games games = new Games();

    public Menu() {
        this.user = new User(); // Initialize user object
    }

    private String language = "svenska"; // Default language

    public void languageChoosing() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Välj språk (svenska/engelska):");
            String selectedLanguage="svenska";
            while (selectedLanguage.isBlank()) {
                if (input.hasNextLine()) {
                    selectedLanguage = input.nextLine().toLowerCase();
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

            System.out.println("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("You chose to create a user.");
                    user.createUser();
                }
                case 2 -> {
                    System.out.println("You chose to update a User.");
                    user.updateUserInDatabase();
                }
                case 3 -> game.playGame();

                case 4 -> {
                    System.out.println("You Chose to warmup");
                    games.warmUp();
                }

                case 5 -> {
                    System.out.println("You chose Count-Uppercase Game");
                    games.countUppercaseWordsGame();
                }

                case 6 ->{
                    System.out.println("You chose to login");
                    user.login();
                }
                case 7 -> startEnglish();
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
            System.out.println("1. Create User");
            System.out.println("2. Update User");
            System.out.println("3. Play Game");
            System.out.println("4. Play Alt Game/Warm up");
            System.out.println("5. Play Find UpperCase words");
            System.out.println("6. Login");
            System.out.println("7. Switch to swedish");

            System.out.println("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1->{
                    System.out.println("You chose to create a user.");
                    user.createUser();
                }


                case 2 -> {
                    System.out.println("You chose to update a User.");
                    user.updateUserInDatabase();
                }

                case 3 -> game.playGame();

                case 4 -> {
                    System.out.println("You Chose to warmup");
                    games.warmUp();
                }

                case 5 -> {
                    System.out.println("You chose Count-Uppercase Game");
                    games.countUppercaseWordsGame();
                }

                case 6 ->{
                    System.out.println("You chose to login");
                    user.login();
                }
                case 7 -> start();


            }
        } while (choice != 0);

        System.out.println("End program");
        System.exit(0);
    }


    public List<String> getMenuOptionsEng() {
        List<String> options = new ArrayList<>();
        options.add("0. End program");
        options.add("1. Create User");
        options.add("2. Update User");
        options.add("3. Play Game");
        options.add("4. Play Alt Game/Warm up");
        options.add("5. Play Find UpperCase words ");
        options.add("6. Login");
        options.add("7. Switch to swedish");
        return options;
    }

    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("0. Avsluta programmet");
        options.add("1. Skapa användare");
        options.add("2. Updatera användare");
        options.add("3. Spela");
        options.add("4. Spela Alt spel");
        options.add("5. Spela Hitta CapsLock orden");
        options.add("6. Logga in");
        options.add("7. Byt till Engelska");
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


