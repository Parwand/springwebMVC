package net.parwand.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/leitfragen")
    public String showAnswers(){
        return "leitfragen";
    }
}
