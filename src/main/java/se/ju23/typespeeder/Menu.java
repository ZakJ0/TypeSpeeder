/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-10
 */
package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService{
    User user;
    MenuService menuService;
    public Menu() {
        this.user = new User(); // Initialize user object
    }

    Game game = new Game();
    public void start() throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to TypeSpeeder!");
            displayMenu();

            System.out.println("choose an alternative: ");
            choice = input.nextInt();
            if (choice > 6) {
                System.out.println("Wrong choice");
            }
            switch (choice) {
                case 1-> {
                    System.out.println("You chose to create a user.");
                    user.createUser();
                }

                case 2-> {
                    System.out.println("You chose to update a User.");
                    user.updateUserInDatabase();
                }
                case 3->
                    game.playGame();
                //case 4->;
                case 5-> {
                    System.out.println("You chose to login");
                    user.readUsersFromDatabase();
                }
            }
        } while (choice != 0);
        System.out.println("End program");
        System.exit(0);
    }


    @Override
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
    @Override
    public void displayMenu() {
        List<String> options = getMenuOptions();
        System.out.println("Menu Options:");
        for (String option : options) {
            System.out.println(option);
        }
    }
}
