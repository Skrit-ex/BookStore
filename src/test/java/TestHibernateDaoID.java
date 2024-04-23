import by.pack.configuration.WebConfiguration;
import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfiguration.class)
public class TestHibernateDaoID {

    @Autowired
    private HibernateBookDao hibernateBookDao;


    @Test
    public void testGenre(){
        BookDto bookDto = new BookDto();
        bookDto.setGenre("comedy");
        Optional<Book> bookOptional = hibernateBookDao.findByGenre(bookDto.getGenre());
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            System.out.println(book.getGenre());
        }
    }
    @Test
    public void testNameBook(){
        BookDto bookDto = new BookDto();
        bookDto.setNameBook("Morty");
        Optional<Book>optionalBook1 = hibernateBookDao.findByBookName(bookDto.getNameBook());
        if(optionalBook1.isPresent()){
            Book book = optionalBook1.get();
            System.out.println(book.getNameBook());
        }
    }
}
