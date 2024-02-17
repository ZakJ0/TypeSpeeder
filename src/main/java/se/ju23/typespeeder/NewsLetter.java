package se.ju23.typespeeder;

import java.time.LocalDateTime;

public class NewsLetter {
    private String content;
    private LocalDateTime publishDateTime;

    public NewsLetter() {
        // Constructor
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(LocalDateTime publishDateTime) {
        this.publishDateTime = publishDateTime;
    }
}
