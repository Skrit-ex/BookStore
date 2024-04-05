package by.pack.controller;

import by.pack.dto.LoginDto;
import by.pack.dto.RegUserDto;
import by.pack.entity.SessionUser;
import by.pack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model){
        model.addAttribute("newUserReg", new RegUserDto());
        return "reg";
    }

    @PostMapping
    public String reg(Model model, BindingResult bindingResult,
                      @ModelAttribute("newUserReg")@Valid RegUserDto regUserDto){
        if(bindingResult.hasErrors()){
            return "reg";
        }
        try{
            userService.save(regUserDto);
        }catch (ConstraintViolationException e){
            model.addAttribute("regError", "User with this username and email already exist" );
        return "reg";
        }
        return "redirect:/user/login";
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("newLoginUser", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("newUserLogin")@Valid LoginDto loginDto,
                        Model model, BindingResult bindingResult, HttpSession httpSession){
        if(bindingResult.hasErrors()){
            return "login";
        }
        Optional<SessionUser> user = userService.login(loginDto);
        if(user.isPresent()){
            httpSession.setAttribute("userSession", user.get());
            return "redirect:/calc";
        }
        else{
            model.addAttribute("loginError" , "Login or password is wrong, try again");
       return "login";
        }
    }
}
