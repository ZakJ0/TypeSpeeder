package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.databas.iUser;

public class XPlevel {
    iUser user;
    private int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void levelUp(User user, double accuracyPercentage) {
        int xpGained = 0;
        if (accuracyPercentage >= 70) {
            // Gain XP
            xpGained = 10; // Adjust the XP gained as per your requirements
            setExperience(getExperience() + xpGained);
            System.out.println("Congratulations! You gained " + xpGained + " XP.");
        } else {
            // Lose XP (if not already at level 1)
            if (getExperience() > 0) {
                xpGained = 5; // Adjust the XP lost as per your requirements
                setExperience(Math.max(0, getExperience() - xpGained));
                System.out.println("You lost " + xpGained + " XP.");
            } else {
                System.out.println("You are already at the lowest level and cannot lose further XP.");
            }
        }
        // Check for level up
        while (getExperience() >= 100) { // Loop to handle multiple level ups if earned XP exceeds 100
            // Level up
            user.setGamelevel((user.getGamelevel() + 1));
            setExperience(getExperience() - 100); // Deduct 100 XP for each level up
            System.out.println("Congratulations! You leveled up to level " + user.getGamelevel() + ".");
        }
    }

    /*
    public void levelUp(User user, double accuracyPercentage) {
        int xpGained = 0;
        if (accuracyPercentage >= 70) {
            // Gain XP
            xpGained = 10; // Adjust the XP gained as per your requirements
            setExperience(getExperience() + xpGained);
            System.out.println("Congratulations! You gained " + xpGained + " XP.");
        } else {
            // Lose XP (if not already at level 1)
            if (getExperience() > 0) {
                xpGained = 5; // Adjust the XP lost as per your requirements
                setExperience(Math.max(0, getExperience() - xpGained));
                System.out.println("You lost " + xpGained + " XP.");
            } else {
                System.out.println("You are already at the lowest level and cannot lose further XP.");
            }
        }
        // Check for level up
        if (getExperience() >= user.getGamelevel()) {
            // Level up
            user.setGamelevel(user.getGamelevel()+1);
            user.setGamelevel(user.getGamelevel()*2);
            System.out.println("Congratulations! You leveled up to level " + user.getGamelevel() + ".");
        }
    }

     */
}
