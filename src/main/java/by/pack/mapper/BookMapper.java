package by.pack.mapper;

import by.pack.dto.BookDto;
import by.pack.entity.Book;
public class BookMapper {

    public static Book bookDtoToBook (BookDto bookDto){
        Book book = new Book();
        book.setNameBook(bookDto.getNameBook());
        book.setNameAuthor(bookDto.getNameAuthor());
        book.setLastNameAuthor(bookDto.getLastNameAuthor());
        book.setGenre(bookDto.getGenre());
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
