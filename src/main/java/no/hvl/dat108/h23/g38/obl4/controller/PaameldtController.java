package no.hvl.dat108.h23.g38.obl4.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.h23.g38.obl4.model.Deltager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaameldtController {

    @GetMapping("/paameldt")
    public String index(Model model, HttpSession session) {
        Deltager deltager = (Deltager) session.getAttribute("Deltager");
        if (deltager == null)
            return "redirect:index";

        model.addAttribute("fornavn", deltager.getFornavn());
        model.addAttribute("etternavn", deltager.getEtternavn());
        model.addAttribute("mobil", deltager.getMobil());
        model.addAttribute("kjonn", deltager.getKjonn());
        return "paameldt";
    }
}
