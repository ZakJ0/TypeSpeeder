package se.ju23.typespeeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.ju23.typespeeder.databas.Leaderboard;
import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.databas.iUser;
import se.ju23.typespeeder.logic.AttemptRepo;
import se.ju23.typespeeder.logic.iGameTask;

import java.util.Scanner;
@Component
public class Main  implements CommandLineRunner {

    @Autowired
    static AttemptRepo attemptRepo;
    @Autowired
    public static iUser iuser;
    @Autowired
    static iGameTask igametask;
    @Autowired
    static Leaderboard leaderboard;
    @Autowired
    public Main(iUser iuser) { // Constructor injection
        this.iuser = iuser;
    }
    private User user= new User();

    public static Scanner input = new Scanner(System.in);
    @Override
    public void run(String[] args)  {
        System.out.println();
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

}
