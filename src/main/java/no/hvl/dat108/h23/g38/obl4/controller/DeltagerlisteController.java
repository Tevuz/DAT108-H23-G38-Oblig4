package no.hvl.dat108.h23.g38.obl4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeltagerlisteController {

    @RequestMapping("/deltagerliste")
    public String index() {
        return "deltagerliste";
    }
}
