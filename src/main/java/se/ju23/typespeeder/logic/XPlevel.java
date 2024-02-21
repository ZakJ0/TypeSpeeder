package se.ju23.typespeeder.logic;
/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-13
 */
import se.ju23.typespeeder.databas.User;
import se.ju23.typespeeder.databas.iUser;

public class XPlevel {

    private int experience;

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int levelUp(User user, double accuracyPercentage) {
        int xpGained = 0;
        if (accuracyPercentage >= 70) {
            // Gain XP
            xpGained = 5;
            user.setXp(user.getXp() + xpGained);
            System.out.println("Congratulations! You gained " + xpGained*2 + " XP.");
        } else {
            // Lose XP (if not already at level 1)
            if (user.getXp() > 5) {
                xpGained = -5;
                user.setXp(Math.max(0, user.getXp() + xpGained));
                System.out.println("You lost " + -xpGained*2 + " XP.");
            } else {
                System.out.println("You are already at the lowest level and cannot lose further XP.");
            }
        }

        // Check for level up
        while (user.getXp() >= 99) {
            // Level up
            user.setGamelevel(user.getGamelevel() + 1);
            user.setXp(user.getXp() - 99);
            System.out.println("Congratulations! You leveled up to level " + user.getGamelevel() + ".");
        }

        return xpGained;
    }
}
