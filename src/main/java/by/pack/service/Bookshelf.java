package by.pack.service;

import by.pack.entity.Book;

public interface Bookshelf {

    void addBook(Book book);

    Book showBooks();

    void getDescription();
}
