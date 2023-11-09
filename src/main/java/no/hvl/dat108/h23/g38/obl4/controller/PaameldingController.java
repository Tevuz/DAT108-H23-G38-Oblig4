package no.hvl.dat108.h23.g38.obl4.controller;

import no.hvl.dat108.h23.g38.obl4.controller.data.DeltagerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PaameldingController {

    @GetMapping("/paamelding")
    public String index() {
        return "paamelding";
    }

    @PostMapping("/paamelding")
    public String submit(DeltagerDTO deltager, Model model) {
        var valid = validate(deltager);
        if (!valid) {
            model.addAttribute("feilmelding", valid ? null : "Påmeldingsdetaljer er ugyldige");
            return "paamelding";
        }

        model.addAttribute("fornavn", deltager.getFornavn());
        model.addAttribute("etternavn", deltager.getEtternavn());
        model.addAttribute("mobil", deltager.getMobil());
        model.addAttribute("kjonn", deltager.getKjonn());
        return "paameldt";
    }

    //TODO: Valider passord og kjonn
    private boolean validate(DeltagerDTO deltager) {
        // Fornavn skal starte med bokstave (kapitalisert)
        // må inneholde 2 til 20 tegn
        // tillatte tegn: bokstaver, bindestrek, mellomrom.
        if (!deltager.getFornavn().matches("^\\p{L}[\\p{L}- ]{1,19}$"))
            return false;

        // Etternavn skal starte med bokstav (kapitalisert)
        // må inneholde 2 til 20 tegn
        // tillatte tegn: bokstaver, bindestrek.
        if (!deltager.getEtternavn().matches("^\\p{L}[\\p{L}-]{1,19}$"))
            return false;

        // Mobilnummer skal ha eksakt 8 desimaltall.
        if (!deltager.getMobil().matches("^\\d{8}$"))
            return false;

        /*if (deltager.getPassord().isBlank())
            return false;
        if (deltager.getPassordRepetert().isBlank())
            return false;*/

        return true;
    }

}
