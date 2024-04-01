package by.pack.service;

import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import by.pack.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private HibernateBookDao hibernateBookDao;

    public void save(BookDto bookDto){
        Book book = BookMapper.bookDtoToBook(bookDto);
        hibernateBookDao.save(book);
    }


}
