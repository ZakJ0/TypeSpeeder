import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patch {
    private String patchVersion;
    public LocalDateTime realeaseDateTime;

    // Constructor
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
}