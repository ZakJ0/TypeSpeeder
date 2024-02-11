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
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TypeSpeeder!");
        displayMenu();

        System.out.println("choose an alternative: ");
        int choice = input.nextInt();

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
            case 4:
                System.out.println("You chose to exit. Bye!");
                System.exit(0);
                break;
            case 5:
                System.out.println("You chose to login");
                user.readUsersFromDatabase();
                break;
            default:
                System.out.println("invalid answer. Test again");



        }
    }


    @Override
    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
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
