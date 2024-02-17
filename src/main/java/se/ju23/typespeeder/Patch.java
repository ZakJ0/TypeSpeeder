package se.ju23.typespeeder;

import java.time.LocalDateTime;



public class Patch {
    private String patchVersion;
    private LocalDateTime releaseDateTime;
    public Patch() {
        // Constructor
    }

    public String getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(String patchVersion) {
        this.patchVersion = patchVersion;
    }

    public LocalDateTime getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(LocalDateTime releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }


}