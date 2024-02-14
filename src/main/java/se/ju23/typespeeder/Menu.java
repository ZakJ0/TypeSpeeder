/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-10
 */
package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.logic.Game;
import se.ju23.typespeeder.logic.iGameTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService{
    User user;
    MenuService menuService;
    iGameTask gameTask;
    public Menu() {
        this.user = new User(); // Initialize user object
    }

    Game game = new Game();
    public void start() throws InterruptedException {
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.println("Välkommen till TypeSpeeder!");
        displayMenu();

        System.out.println("Skriv in ditt alternativ: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Du valde att skapa en User:");
                user.createUser();

                break;
            case 2:
                System.out.println("Du valde att uppdatera en användare:");
                user.updateUserInDatabase();
                break;
            case 3:
                System.out.println("Du valde att spela:");
                game.playGame();
                break;
            case 4:

                break;
            case 5:
                System.out.println("Du valde att avsluta. Hejdå!");
                System.exit(0);
                break;
            default:
                System.out.println("Ogiltigt svar. Testa igen");
        }
    }


    @Override
    public List<String> getMenuOptions() {
        List<String> options = new ArrayList<>();
        options.add("1. Create User");
        options.add("2. Update User");
        options.add("3. Play Game");
        options.add("4. ");
        options.add("5. Exit game");
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
