import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Patch {

     public String patchVersion;
     public LocalDateTime realeaseDateTime ;


    public Patch() {
        try {
            this.patchVersion = getPatchVersion();
            this.realeaseDateTime = LocalDateTime.now();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    public LocalDateTime getReleaseDateTime() {
        return realeaseDateTime;
    }

    public void setReleaseDateTime(LocalDateTime releaseDateTime) {
        this.realeaseDateTime = releaseDateTime;
    }

    public String formattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = realeaseDateTime.format(formatter);
        return formattedDateTime;
    }
}