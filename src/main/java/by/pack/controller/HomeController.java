package by.pack.controller;

import by.pack.dto.RegUserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public String home(Model model){
        model.addAttribute("newUser", new RegUserDto());
        return "home";
    }

    @PostMapping
    public String home(Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "home";
        }
        return "home";
    }
}
