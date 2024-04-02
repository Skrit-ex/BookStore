package by.pack.libraryBook;

import by.pack.entity.Book;
import by.pack.service.Bookshelf;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class LibraryBooks {


    private List<Book> books = new ArrayList<>();

    public void showAllBooks(){
        for (Book book:books){

        }
    }
}
