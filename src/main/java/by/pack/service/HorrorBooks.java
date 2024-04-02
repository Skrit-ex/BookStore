package by.pack.service;

import by.pack.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class HorrorBooks implements Bookshelf{

    @Autowired
    private Book book;

    @Override
    public void addBook(Book book) {
        List<Book> books = new ArrayList<>();
        books.add(book);
    }

    @Override
    public Book showBooks() {
        return book;
    }

    @Override
    public void getDescription() {

    }
}
