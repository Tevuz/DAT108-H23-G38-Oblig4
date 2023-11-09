package no.hvl.dat108.h23.g38.obl4.controller.data;

import no.hvl.dat108.h23.g38.obl4.model.Passord;

public class DeltagerDTO {
    private String mobil;
    private String passord;
    private String passordRepetert;
    private String fornavn;
    private String etternavn;
    private String kjonn;

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPassordRepetert() {
        return passordRepetert;
    }

    public void setPassordRepetert(String passordRepetert) {
        this.passordRepetert = passordRepetert;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
}
