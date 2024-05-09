package by.pack.controller;

import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import by.pack.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.validation.ConstraintDeclarationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private HibernateBookDao hibernateBookDao;


    @GetMapping
    public String library( Model model) {
        List<Book> books = hibernateBookDao.findAll();

        model.addAttribute("books", books);

//        for (Book book : books) {
//
////       Book book = hibernateBookDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid argument " +
////                "book Id :" + id));
//
//            String nameBook = book.getNameBook();
//            String nameAuthor = book.getNameAuthor();
//            String lastNameAuthor = book.getLastNameAuthor();
//            String genre = book.getGenre();
//
//            model.addAttribute("nameBook", nameBook);
//            model.addAttribute("nameAuthor", nameAuthor);
//            model.addAttribute("lastNameAuthor", lastNameAuthor);
//            model.addAttribute("genre", genre);
//        }
//        model.addAttribute("newBook", new BookDto());
//        Book book1 = bookService.bookInfo;
//        String bookName = book1.getNameBook();
//        System.out.println(bookName);
//        model.addAttribute("nameBook", bookName);

            return "library";
        }

    @GetMapping("/search")
    public String search(@RequestParam("nameBook") String nameBook,
                         @RequestParam("nameAuthor") String nameAuthor,
                          Model model){
        if(nameBook != null && !nameBook.isEmpty() ){
            Optional<Book> books = hibernateBookDao.findByBookName(nameBook);
            books.ifPresent(book -> model.addAttribute("nameBook", nameBook));
        }
        if(nameAuthor != null && !nameAuthor.isEmpty()) {
            Optional<Book> author = hibernateBookDao.findByNameAuthor(nameAuthor);
            author.ifPresent(book -> model.addAttribute("nameAuthor", nameAuthor));
        }
        return "library";
        }

    @GetMapping("/adBook")
    public String adBook(Model model){
        model.addAttribute("adNewBook", new BookDto());
        return "adBook";
    }

    @PostMapping("/adBook")
    public String adBook(@ModelAttribute("adNewBook") @Valid BookDto bookDto,
                         BindingResult bindingResult,
                         Model model){
        if(bindingResult.hasErrors()){
            return "adBook";
        }
        try {
            bookService.save(bookDto);
        }catch (ConstraintDeclarationException e){
            model.addAttribute("errorBook", "You entered error Book, try again");
            return "adBook";
        }
        return "redirect:/";
    }

}
