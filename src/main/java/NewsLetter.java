
import java.time.LocalDateTime;

        import java.time.format.DateTimeFormatter;

public class NewsLetter {
    public String content;
    public LocalDateTime publishDateTime;

    public NewsLetter() {
        this.content = "Content field length should be at least 100 characters.Content field length should be at least 100 characters.Content field length should be at least 100 characters."; // Initialize content to an empty string
        this.publishDateTime = LocalDateTime.of(2024, 2, 17, 11, 41, 38);
    }

    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }
}