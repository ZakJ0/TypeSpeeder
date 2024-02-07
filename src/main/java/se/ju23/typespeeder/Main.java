package se.ju23.typespeeder;

import java.util.Scanner;

public class Main {

    public static void main (String[]args){
        Scanner input = new Scanner(System.in);

        System.out.println("Välkommen till TypeSpeeder!");
        System.out.println("1. Logga in");
        System.out.println("2. Skapa användare");
        System.out.println("3. Exit");

        System.out.println("Skriv in ditt alternativ: ");
        int choice = input.nextInt();

        switch(choice) {
            case 1:
                System.out.println("Du valde att logga in.");
                // Add login functionality here
                break;
            case 2:
                System.out.println("Du valde att skapa en användare.");
                // Add create user functionality here
                break;
            case 3:
                System.out.println("Du valde att avsluta. Hejdå!");
                System.exit(0);
                break;
            default:
                System.out.println("Ogiltigt svar. Testa igen");
        }
    }


}
