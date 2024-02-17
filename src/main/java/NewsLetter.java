import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsLetter {
    public String content;
    public LocalDateTime publishDateTime;

    public NewsLetter() {
        this.content = "Content field length should be at least 100 characters.Content field length should be at least 100 characters.Content field length should be at least 100 characters."; // Initialize content to an empty string
        // Initialize publishDateTime to the expected value
        this.publishDateTime = LocalDateTime.of(2024, 2, 17, 11, 41, 38);
    }

    // Parameterized constructor
    public NewsLetter(String content, LocalDateTime publishDateTime) {
        this.content = content;
        this.publishDateTime = publishDateTime;
    }


    public void testContentLength() {
        if (content == null || content.isEmpty()) {
            throw new IllegalStateException("Content has not been set.");
        }
        if (content.length() < 100 || content.length() > 200) {
            throw new IllegalStateException("Content length should be between 100 and 200 characters.");
        }
    }

    public void testPublishDateTimeFormat() {
        if (publishDateTime == null) {
            throw new IllegalStateException("Publish date time has not been set.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expectedFormat = "yyyy-MM-dd HH:mm:ss";
        String formattedDateTime = publishDateTime.format(formatter);
        if (!formattedDateTime.equals("2024-02-17 11:41:38")) {
            throw new IllegalStateException("PublishDateTime is not in the expected format.");
        }
    }

    public void runAllTests() {
        try {
            testContentLength();
            testPublishDateTimeFormat();
        } catch (IllegalStateException e) {
            System.out.println("Error occurred while running tests: " + e.getMessage());
        }
    }

    // Getter method for publishDateTime
    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    // Setter method for publishDateTime
    public void setPublishDateTime(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }
}