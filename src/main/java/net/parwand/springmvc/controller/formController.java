package net.parwand.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class formController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/formResult").setViewName("formResult");
    }

    @GetMapping("/form")
    public String showForm(){
       return "form";
    }

    @PostMapping("/form")
    public String ProcessForm(String name, Model model){
        System.out.println("the input in the form: "+name);
        model.addAttribute("name", name);
        return "formResult";
    }
}
