package by.pack.controller;

import by.pack.dao.HibernateBookDao;
import by.pack.entity.Book;
import by.pack.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
                         @RequestParam("lastNameAuthor") String lastNameAuthor, Model model){
        Optional<Book> books = hibernateBookDao.findByBookName(nameBook);
        model.addAttribute("nameBook", nameBook);
        Optional<Book> author = hibernateBookDao.findByNameAuthor(nameAuthor);
        model.addAttribute("nameAuthor", nameAuthor);
        return "library";
        }

}
