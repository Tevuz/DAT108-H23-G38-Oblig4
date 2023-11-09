package no.hvl.dat108.h23.g38.obl4.controller;

import no.hvl.dat108.h23.g38.obl4.controller.data.DeltagerDTO;
import no.hvl.dat108.h23.g38.obl4.model.Deltager;
import no.hvl.dat108.h23.g38.obl4.model.Passord;
import no.hvl.dat108.h23.g38.obl4.service.DeltagerService;
import no.hvl.dat108.h23.g38.obl4.service.EntityStateException;
import no.hvl.dat108.h23.g38.obl4.service.PassordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaameldingController {

    private final DeltagerService deltagerService;
    private final PassordService passordService;

    public PaameldingController(DeltagerService deltagerService, PassordService passordService) {
        this.deltagerService = deltagerService;
        this.passordService = passordService;
    }

    @GetMapping("/paamelding")
    public String index() {
        return "paamelding";
    }

    @PostMapping("/paamelding")
    public String submit(DeltagerDTO dto, Model model) {
        var valid = validate(dto);
        if (!valid) {
            model.addAttribute("feilmelding", valid ? null : "Påmeldingsdetaljer er ugyldige");
            return "paamelding";
        }

        var passord = new Passord();
        passord.setSalt(passordService.genererTilfeldigSalt());
        passord.setHash(passordService.hashMedSalt(dto.getPassord(), passord.getSalt()));

        var deltager = new Deltager();
        deltager.setFornavn(dto.getFornavn());
        deltager.setEtternavn(dto.getEtternavn());
        deltager.setMobil(dto.getMobil());
        deltager.setPassord(passord);
        deltager.setKjonn(dto.getKjonn());

        try {
            deltagerService.create(deltager);
        } catch (EntityStateException e) {
            model.addAttribute("feilmelding", valid ? null : "Deltager med samme mobilnummer er allerede registrert");
            return "paamelding";
        }

        return "redirect:paameldt";
    }

    private boolean validate(DeltagerDTO deltager) {
        // Fornavn skal starte med bokstave (kapitalisert)
        // må inneholde 2 til 20 tegn
        // tillatte tegn: bokstaver, bindestrek, mellomrom.
        if (!deltager.getFornavn().matches("^\\p{L}(\\p{L}|-| ){1,19}$"))
            return false;

        // Etternavn skal starte med bokstav (kapitalisert)
        // må inneholde 2 til 20 tegn
        // tillatte tegn: bokstaver, bindestrek.
        if (!deltager.getEtternavn().matches("^\\p{L}(\\p{L}|-){1,19}$"))
            return false;

        // Mobilnummer skal ha eksakt 8 desimaltall.
        if (!deltager.getMobil().matches("^\\d{8}$"))
            return false;

        if (deltager.getPassord().isBlank())
            return false;

        if (!deltager.getKjonn().matches("^(mann|kvinne)$"))
            return false;

        return true;
    }

}
