/*Zakaria Jaouhari
30-01-24
zakaria.jaouhari@iths.se*/
package se.ju23.typespeeder.io;

import java.util.Scanner;

public class WindowIO implements IO {
    private Scanner input = new Scanner(System.in);
    @Override
    public String input() {
        return input.nextLine();
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }

    @Override
    public void exit() {
        System.exit(0);
    }

}
