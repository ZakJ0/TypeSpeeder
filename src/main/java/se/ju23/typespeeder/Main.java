package se.ju23.typespeeder;
/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-8
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.ju23.typespeeder.databas.LeaderboardRepo;
import se.ju23.typespeeder.databas.iUser;
import se.ju23.typespeeder.io.UserCreateUpdate;
import se.ju23.typespeeder.io.Valid;
import se.ju23.typespeeder.logic.AttemptRepo;

import se.ju23.typespeeder.logic.iGameTask;


import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    public static AttemptRepo attemptRepo;
    @Autowired
    public static iUser iuser;
    @Autowired
    public static iGameTask igametask;
    @Autowired
    public static LeaderboardRepo leaderboard;

    @Autowired
    public Main(iUser iuser, AttemptRepo attemptRepo1, iGameTask igametask, LeaderboardRepo leaderboard) {
        this.iuser = iuser;
        this.attemptRepo = attemptRepo1;
        this.igametask = igametask;
        this.leaderboard = leaderboard;
    }

    Valid valid = new Valid();
    UserCreateUpdate up = new UserCreateUpdate();

    public static Scanner input = new Scanner(System.in);

    @Override
    public void run(String[] args) {
        boolean loggedIn = false;
        Menu menu = new Menu();
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
        menu.start();
        System.out.println();
    }
}
