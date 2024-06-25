package by.pack.controller;

import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import by.pack.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintDeclarationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
            model.addAttribute("bookAddedSuccessfully", true);

        }catch (ConstraintDeclarationException e){
            model.addAttribute("errorBook", "You entered error Book, try again");
            return "adBook";
        }
        return "redirect:/library";
    }

    @GetMapping("/search")
    public String getBookInfo(@RequestParam(value = "id", required = false) Long id,
                              @RequestParam(value = "nameBook", required = false) String nameBook,
                              @RequestParam(value = "nameAuthor", required = false) String nameAuthor,
                              @RequestParam(value = "lastnameAuthor", required = false) String lastNameAuthor,
                              Model model){
        if(nameBook != null && !nameBook.isEmpty()){
            Optional<Book> findByNameBook = hibernateBookDao.findByBookName(nameBook);
            findByNameBook.ifPresent(book -> model.addAttribute("book", book));
            return "bookInfo";
        }
        if(nameAuthor !=null && !nameAuthor.isEmpty()) {
            Optional<Book> findByNameAuthor = hibernateBookDao.findByNameAuthor(nameAuthor);
            findByNameAuthor.ifPresent(book -> model.addAttribute("book", book));
            return "bookInfo";
        }
            return "redirect:/library";
    }

}

