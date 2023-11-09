package no.hvl.dat108.h23.g38.obl4.controller;

import junit.framework.TestCase;
import no.hvl.dat108.h23.g38.obl4.controller.data.DeltagerDTO;
import org.junit.Test;

public class PaameldingControllerTest extends TestCase {

    @Test
    public void testValidate() {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setFornavn("Ole");
        dto.setEtternavn("Olsen");
        dto.setMobil("12345678");
        dto.setPassord("password");
        dto.setKjonn("mann");

        assertTrue(PaameldingController.validate(dto));
    }

    @Test
    public void testValidateFornavn() {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setEtternavn("Olsen");
        dto.setMobil("12345678");
        dto.setPassord("password");
        dto.setKjonn("mann");

        dto.setFornavn("");
        assertFalse(PaameldingController.validate(dto));

        dto.setFornavn("A");
        assertFalse(PaameldingController.validate(dto));

        dto.setFornavn("Aa");
        assertTrue(PaameldingController.validate(dto));

        dto.setFornavn("Aa.");
        assertFalse(PaameldingController.validate(dto));

        dto.setFornavn("A-");
        assertTrue(PaameldingController.validate(dto));

        dto.setFornavn("-A");
        assertFalse(PaameldingController.validate(dto));

        dto.setFornavn("abc def ghi jkl mnop");
        assertTrue(PaameldingController.validate(dto));

        dto.setFornavn("abc def-ghi-jkl mnopq");
        assertFalse(PaameldingController.validate(dto));
    }

    @Test
    public void testValidateEtternavn() {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setFornavn("Ole");
        dto.setEtternavn("Olsen");
        dto.setMobil("12345678");
        dto.setPassord("password");
        dto.setKjonn("mann");

        dto.setEtternavn("");
        assertFalse(PaameldingController.validate(dto));

        dto.setEtternavn("Aa");
        assertTrue(PaameldingController.validate(dto));

        dto.setEtternavn("Aa.");
        assertFalse(PaameldingController.validate(dto));
    }

    @Test
    public void testValidateMobil() {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setFornavn("Ole");
        dto.setEtternavn("Olsen");
        dto.setPassord("password");
        dto.setKjonn("mann");

        dto.setMobil("1234567");
        assertFalse(PaameldingController.validate(dto));

        dto.setMobil("123456789");
        assertFalse(PaameldingController.validate(dto));

        dto.setMobil("12345678");
        assertTrue(PaameldingController.validate(dto));

        dto.setMobil("123---78");
        assertFalse(PaameldingController.validate(dto));

        dto.setMobil("12345678--");
        assertFalse(PaameldingController.validate(dto));
    }

    @Test
    public void testValidatePassword() {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setFornavn("Ole");
        dto.setEtternavn("Olsen");
        dto.setMobil("12345678");
        dto.setKjonn("mann");

        dto.setPassord("");
        assertFalse(PaameldingController.validate(dto));

        dto.setPassord("a");
        assertTrue(PaameldingController.validate(dto));
    }

    @Test
    public void testValidateKjonn() {
        DeltagerDTO dto = new DeltagerDTO();
        dto.setFornavn("Ole");
        dto.setEtternavn("Olsen");
        dto.setMobil("12345678");
        dto.setPassord("password");

        dto.setKjonn("mann");
        assertTrue(PaameldingController.validate(dto));

        dto.setKjonn("kvinne");
        assertTrue(PaameldingController.validate(dto));

        dto.setKjonn("");
        assertFalse(PaameldingController.validate(dto));

        dto.setKjonn("annet");
        assertFalse(PaameldingController.validate(dto));
    }
}