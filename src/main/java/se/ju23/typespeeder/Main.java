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


    public static Scanner input = new Scanner(System.in);

    @Override
    public void run(String[] args) {
        Menu menu = new Menu();
        menu.loginMenu();
        menu.start();
        System.out.println();
    }

}
