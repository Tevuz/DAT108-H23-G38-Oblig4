package no.hvl.dat108.h23.g38.obl4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Deltager implements ModelEntity<String> {

    @Id
    private String mobil;
    private Passord passord;
    private String fornavn;
    private String etternavn;
    private String kjonn;

    @Override
    public String getID() {
        return getMobil();
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String phone) {
        this.mobil = phone;
    }

    public Passord getPassord() {
        return passord;
    }

    public void setPassord(Passord password) {
        this.passord = password;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String firstName) {
        this.fornavn = firstName;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String lastName) {
        this.etternavn = lastName;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String sex) {
        this.kjonn = sex;
    }
}
