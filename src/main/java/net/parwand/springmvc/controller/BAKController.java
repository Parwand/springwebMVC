package net.parwand.springmvc.controller;

import net.parwand.springmvc.service.BAKService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Controller
public class BAKController {
    private final List<Double> getraenkemengen = new LinkedList<>();
    private final BAKService bakService;

    public BAKController(BAKService bakService) {
        this.bakService = bakService;
    }

    @GetMapping("BAK")
    public String showForm(){
        return "BAKForm";
    }

    @PostMapping("BAK")
    public String processForm(String geschlecht,
                              @RequestParam(required = false, defaultValue = "0.0") Double gewicht,
                              @RequestParam(required = false, defaultValue = "0.0") Double bierMenge,
                              @RequestParam(required = false, defaultValue = "0.0") Double weinMenge,
                              @RequestParam(required = false, defaultValue = "0.0") Double kornMenge,
                              @RequestParam(required = false, defaultValue = "0.0") Double vodkaMenge,
                              @RequestParam(required = false, defaultValue = "0.0") Double whiskeyMenge,
                              Model model){

        getraenkemengen.add(bierMenge);
        getraenkemengen.add(weinMenge);
        getraenkemengen.add(kornMenge);
        getraenkemengen.add(vodkaMenge);
        getraenkemengen.add(whiskeyMenge);
        Double result = bakService.berechnen(geschlecht, gewicht, getraenkemengen);
        model.addAttribute("result", result);
        getraenkemengen.clear();
        return "BAKResult";
    }
}
