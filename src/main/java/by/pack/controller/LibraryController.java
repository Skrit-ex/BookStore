package by.pack.controller;

import by.pack.dto.BookDto;
import by.pack.dto.RegUserDto;
import by.pack.entity.Book;
import by.pack.mapper.BookMapper;
import by.pack.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Component
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public String library(Model model){
        model.addAttribute("newUser", new RegUserDto());
        return "library";
    }

    @PostMapping
    public String library(BindingResult bindingResult, Model model, @Valid BookDto bookDto){
        Optional<Book> book = Optional.of(BookMapper.bookDtoToBook(bookDto));
        model.addAttribute("author",  book.get().getNameAuthor() );
        return "library";
    }
}
