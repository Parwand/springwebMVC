package net.parwand.springmvc.controller;

import net.parwand.springmvc.entity.PersonForm;
import net.parwand.springmvc.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController implements WebMvcConfigurer {




    @GetMapping("/rest")
    public @ResponseBody List<Person> showList(){
        List<Person> persons = List.of(
                // Erzeugen Sie eine Liste mit einigen Personen-Objekten
                new Person("Max", 30),
                new Person("Mo", 28),
                new Person("Lea", 25)
        );
        return persons;
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/personForm")
    public String showForm(PersonForm personForm){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(personForm);
        return "personForm";
    }

    @PostMapping("personForm")
    public String checkPerson(@Valid PersonForm personForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "personForm";
        }
        return "redirect:/result";
    }
}
