package by.pack.controller;

import by.pack.dto.LoginDto;
import by.pack.dto.RegUserDto;
import by.pack.entity.SessionUser;
import by.pack.service.BookService;
import by.pack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("newUserReg", new RegUserDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute("newUserReg") @Valid RegUserDto regUserDto,
                      Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        try {
            userService.save(regUserDto);
        } catch (ConstraintViolationException e) {
            model.addAttribute("regError", "User with this username and email already exist");
            return "reg";
        }
        return "redirect:/user/login";
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("newUserLogin", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("newUserLogin") @Valid LoginDto loginDto,
                        BindingResult bindingResult,
                        Model model,
                        HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Optional<SessionUser> sessionUser = userService.login(loginDto);
        if (sessionUser.isPresent()) {
            httpSession.setAttribute("userSession", sessionUser.get());
            bookService.saveBook();
            bookService.saveDescription();
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "Login or password is wrong, try again");
            return "login";
        }

    }

}
