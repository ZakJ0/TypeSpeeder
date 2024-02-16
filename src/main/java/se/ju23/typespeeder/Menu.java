/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-10
 */
package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.logic.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService{
    User user;
    MenuService menuService;
    Game game = new Game();


    public Menu() {
        this.user = new User(); // Initialize user object
    }

    private String language = "English"; // Default language

    public void languageChoosing() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the language (Swedish/English):");
        String selectedLanguage = input.nextLine().toLowerCase();

        if (selectedLanguage.equals("swedish") || selectedLanguage.equals("s")) {
            language = "Swedish";
        } else if (selectedLanguage.equals("english") || selectedLanguage.equals("e")) {
            language = "English";
        } else {
            System.out.println("Invalid language selection. Default language set to English.");
            language = "English";
        }
    }

    public void start()  {

        Scanner input = new Scanner(System.in);
        int choice;

        try {
            do {
                System.out.println("Welcome to TypeSpeeder - " + language);
                displayMenu();

                System.out.println("Choose an option: ");
                choice = input.nextInt();
                if (choice > 5) {
                    System.out.println("Wrong choice");
                }
                switch (choice) {
                    case 1:
                        System.out.println("You chose to create a user.");
                        user.createUser();
                        break;
                    case 2:
                        System.out.println("You chose to update a User.");
                        user.updateUserInDatabase();
                        break;
                    case 3:
                        game.playGame();
                        break;
                    case 5:
                        System.out.println("You chose to login");
                        user.login();
                        break;
                }
            } while (choice != 0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End program");
        System.exit(0);
    }


    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("0. End program");
        options.add("1. Create User");
        options.add("2. Update User");
        options.add("3. Play Game");
        options.add("4. Exit game");
        options.add("5. Login");
        return options;
    }

    public List<String> getMenuOptionsSwe() {
        List<String> options = new ArrayList<>();
        options.add("0. Avsluta programmet");
        options.add("1. Skapa användare");
        options.add("2. Updatera användare");
        options.add("3. Spela");
        options.add("4. -----");
        options.add("5. Logga in");
        return options;
    }


    public void displayMenu() {
        languageChoosing();

        if (language.equalsIgnoreCase("swedish")){
            List<String> sweOptions = getMenuOptionsSwe();
            System.out.println("Meny Alternativ - " + language + ":");
            for (String option : sweOptions) {
                System.out.println(option);
            }
        }else {
            List<String> options = getMenuOptions(); // or getMenuOptionsSwe() based on the selected language
            System.out.println("Menu Options - " + language + ":");
            for (String option : options) {
                System.out.println(option);
            }
        }

    }
}
