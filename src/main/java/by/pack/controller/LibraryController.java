package by.pack.controller;

import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import by.pack.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@Component
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private HibernateBookDao hibernateBookDao;


    @GetMapping
    public String library(Model model){
        model.addAttribute("newBook", new BookDto());
        Book book1 = bookService.bookInfo;
        String bookName = book1.getNameBook();
        System.out.println(bookName);
        model.addAttribute("nameBook", bookName);
        return "library";
    }

    @PostMapping
    public String library(@ModelAttribute("newBook") BookDto bookDto,
                          BindingResult bindingResult,
                          HttpSession httpSession,
                          Model model) {
        if (bindingResult.hasErrors()) {
            return "library";
        }




        return "library";
    }
}
