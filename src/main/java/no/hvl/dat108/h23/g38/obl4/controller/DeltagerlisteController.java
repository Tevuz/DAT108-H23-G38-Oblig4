package no.hvl.dat108.h23.g38.obl4.controller;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.h23.g38.obl4.controller.data.DeltagerListDTO;
import no.hvl.dat108.h23.g38.obl4.model.Deltager;
import no.hvl.dat108.h23.g38.obl4.service.DeltagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DeltagerlisteController {

    private DeltagerService deltagerService;

    public DeltagerlisteController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }


    @RequestMapping("/deltagerliste")
    public String index(Model model, HttpSession session) {
        Deltager deltager = (Deltager) session.getAttribute("Deltager");
        if (deltager == null)
            return "redirect:index";

        model.addAttribute("fornavn", deltager.getFornavn());
        model.addAttribute("etternavn", deltager.getEtternavn());
        model.addAttribute("mobil", deltager.getMobil());

        var deltagere = new ArrayList<Deltager>();
        deltagerService.readAll().forEach(deltagere::add);

        var tableData = deltagere.stream().map(entity -> {
            var dto = new DeltagerListDTO();
            dto.setFornavn(entity.getFornavn());
            dto.setEtternavn(entity.getEtternavn());
            dto.setMobil(entity.getMobil());
            dto.setKjonn(entity.getKjonn());
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("deltagere", tableData);

        return "deltagerliste";
    }
}
