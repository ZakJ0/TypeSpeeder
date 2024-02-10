/*Zakaria Jaouhari
2024-02-08
zakaria.jaouhari@iths.se
 */
package se.ju23.typespeeder;

public enum ConsoleColor {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m");
    private final String code;

    ConsoleColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
