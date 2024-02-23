package se.ju23.typespeeder;
/*
Zakaria Jaouhari, Emanuel Sleyman
2024-02-20
 */

import se.ju23.typespeeder.io.Valid;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patch implements iPatch {
    private String patchVersion;
    public LocalDateTime realeaseDateTime;
    private Valid valid = new Valid();


    public Patch() {
        this.realeaseDateTime = LocalDateTime.of(2024, 2, 17, 11, 41, 38);
    }

    public Patch(String patchVersion, LocalDateTime releaseDateTime) {
        this.patchVersion = patchVersion;
        this.realeaseDateTime = releaseDateTime;
    }


    public Patch(LocalDateTime releaseDateTime) {
        this.realeaseDateTime = releaseDateTime;
    }

    // Getters and setters
    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    public void getRealeaseDateTime() {
        if (realeaseDateTime == null) {
            throw new IllegalStateException("Publish date time has not been set.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expectedFormat = "yyyy-MM-dd HH:mm:ss";
        String formattedDateTime = realeaseDateTime.format(formatter);
        if (!formattedDateTime.equals("2024-02-17 11:41:38")) {
            throw new IllegalStateException("PublishDateTime is not in the expected format.");
        }
    }

    public boolean printNewRealease() {

        patchVersion = "1.0";
        realeaseDateTime = LocalDateTime.now();
        System.out.println("Do you want to see the patches? (yes/no)");
        String input = valid.validInput().trim().toLowerCase();
        if (input.equals("yes")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = realeaseDateTime.format(formatter);
            System.out.println("New Beta Version!!! , Version: " + patchVersion + " Datum " + formattedDateTime);
            return true;
        } else if (input.equals("no")) {
            System.out.println("Updates declined.");
            return false;
        } else {
            System.out.println("Invalid input. Updates declined.");
            return false;
        }
    }
}