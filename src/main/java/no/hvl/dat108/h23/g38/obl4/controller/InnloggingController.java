package no.hvl.dat108.h23.g38.obl4.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.h23.g38.obl4.controller.data.LoggInnDTO;
import no.hvl.dat108.h23.g38.obl4.service.DeltagerService;
import no.hvl.dat108.h23.g38.obl4.service.PassordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InnloggingController {

    private DeltagerService deltagerService;
    private PassordService passordService;

    public InnloggingController(DeltagerService deltagerService, PassordService passordService) {
        this.deltagerService = deltagerService;
        this.passordService = passordService;
    }

    @RequestMapping("/innlogging")
    public String index() {
        return "innlogging";
    }

    @PostMapping("/innlogging")
    public String loggInn(LoggInnDTO dto, Model model, HttpSession session) {
        var deltagerOption = deltagerService.readById(dto.getMobil());
        if (deltagerOption.isEmpty()) {
            model.addAttribute("feilmelding", "Feil brukernavn eller passord");
            return "innlogging";
        }

        var deltager = deltagerOption.get();
        if (!passordService.erKorrektPassord(dto.getPassord(), deltager.getPassord().getSalt(), deltager.getPassord().getHash())) {
            model.addAttribute("feilmelding", "Feil brukernavn eller passord");
            return "innlogging";
        }

        session.setAttribute("Deltager", deltager);

        return "redirect:deltagerliste";
    }
}
