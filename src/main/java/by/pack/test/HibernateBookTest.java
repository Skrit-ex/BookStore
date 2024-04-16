package by.pack.test;

import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateBookTest {

    @Autowired
    private HibernateBookDao hibernateBookDao;

    public void initializerHibernateBookDao(){
        this.hibernateBookDao= new HibernateBookDao();
    }
    @Test
    public void testFindByNameBook() {
        BookDto bookDto = new BookDto();
        bookDto.setNameBook("Morty");
        Optional<Book> byNameBook = hibernateBookDao.findByNameBook(bookDto.getNameBook());
        if (byNameBook.isPresent()) {
            Book book = byNameBook.get();
            System.out.println(book);
        }
    }
}
