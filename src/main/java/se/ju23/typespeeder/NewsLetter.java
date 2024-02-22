package se.ju23.typespeeder;

import se.ju23.typespeeder.io.Valid;

import java.time.LocalDateTime;

        import java.time.format.DateTimeFormatter;

public class NewsLetter {
    public String content;
    public LocalDateTime publishDateTime;
    private Valid valid= new Valid();

    public NewsLetter() {
        this.content = "This is new game thats is being released. We want as many users to try out, so we can find bugs and get feedback from users on what we need to fix! Spread it in your social media, maximize publicity."; // Initialize content to an empty string
        this.publishDateTime = LocalDateTime.of(2024, 2, 17, 11, 41, 38);
    }

    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }
    public boolean printNewsLetter(){
        content = "This is a new game that's is being released. We want as many users as possible to try it out, " +
                "so we can find bugs and get feedback from users on what we need to fix! Spread it in " +
                "your social media, maximize publicity please.\"";
        publishDateTime = LocalDateTime.of(2024, 2, 21, 16, 00, 00);
        System.out.println("Do you want to see the newsLetter sent-out by admin? (yes/no)");
        String input = valid.validInput().trim().toLowerCase();
        if (input.equals("yes")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = publishDateTime.format(formatter);
            System.out.println(content + " Datum " + formattedDateTime);
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