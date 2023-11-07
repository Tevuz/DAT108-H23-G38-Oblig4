package no.hvl.dat108.h23.g38.obl4.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Passord {

    private String hash;
    private String salt;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
