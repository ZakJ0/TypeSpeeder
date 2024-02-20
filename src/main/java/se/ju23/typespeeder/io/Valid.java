package se.ju23.typespeeder.io;

import se.ju23.typespeeder.Main;

public class Valid {

    public String validInput() {
        String inputString;
        while (true) {
            inputString = Main.input.nextLine().trim();
            if (inputString.isEmpty()) {
                System.out.println("Wrong input. You have to actually write something!");
            } else {
                return inputString;
            }
        }
    }

    public long readLongOnly() {
        while (true) {
            try {
                return Long.parseLong(validInput());
            } catch (NumberFormatException e) {
                System.err.println("wrong input. Please enter an integer or double with ,: ");
            }
        }
    }

    public int readIntOnly() {
        while (true) {
            try {
                int intOnly = Integer.parseInt(validInput());
                return intOnly;
            } catch (NumberFormatException e) {
                System.err.println(e + "Wrong input. Please enter an integer:");
            }
        }
    }
}
