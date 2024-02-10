/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-10
 */
package se.ju23.typespeeder;

import se.ju23.typespeeder.databas.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu implements MenuService{
    User user;
    MenuService menuService;
    public void start(){
    System.out.println();
    Scanner input = new Scanner(System.in);
        System.out.println("Välkommen till TypeSpeeder!");
        getMenuOptions();

        System.out.println("Skriv in ditt alternativ: ");
    int choice = input.nextInt();

        switch(choice) {
        case 1:
            System.out.println("Du valde att logga in.");
            user.createUser();

            break;
        case 2:
            System.out.println("Du valde att skapa en användare.");
            user.updateUserInDatabase();
            break;
        case 3:
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
        options.add("Option 1");
        options.add("Option 2");
        options.add("Option 3");
        options.add("Option 4");
        options.add("Option 5");
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
