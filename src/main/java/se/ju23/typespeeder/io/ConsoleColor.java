/*Zakaria Jaouhari
2024-02-08
zakaria.jaouhari@iths.se
 */
package se.ju23.typespeeder.io;

public enum ConsoleColor {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    LIGHT_PINK("\u001B[95m"),
    LIGHT_GREEN("\u001B[92m"),
    LIGHT_BLUE("\u001B[94m");
    private final String code;

    ConsoleColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
