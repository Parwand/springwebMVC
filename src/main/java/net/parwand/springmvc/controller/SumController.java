package net.parwand.springmvc.controller;

import net.parwand.springmvc.entity.Sum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SumController {

    @GetMapping("sum")
    public String sum(){
        return "sum";
    }

    @PostMapping("sum")
    public String sum(Sum sum, Model model){
        model.addAttribute("result", sum.add());
        return "sum";
    }
}
