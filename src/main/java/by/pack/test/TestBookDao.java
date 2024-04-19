package by.pack.test;

import by.pack.configuration.WebConfiguration;
import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfiguration.class)
    public class TestBookDao {

        private static HibernateBookDao hibernateBookDao;

        @Before
        public void setUp() {
            hibernateBookDao = new HibernateBookDao();
        }

        @Test
        public void testFindByAuthor(){
            BookDto bookDto = new BookDto();
            bookDto.setNameAuthor("Tammy");
            Optional<Book> bookOptional = hibernateBookDao.findByAuthor(bookDto.getNameAuthor());
            if(bookOptional.isPresent()){
                Book book1 = bookOptional.get();
                System.out.println(book1.getNameAuthor());
            }
        }

        @Test
        public void testFindByNameBook() {
            BookDto bookDto = new BookDto();
            bookDto.setNameBook("Morty");
            Optional<Book> byNameBook = hibernateBookDao.findByNameBook(bookDto.getNameBook());
            if (byNameBook.isPresent()) {
                Book book = byNameBook.get();
                System.out.println(book.getNameBook());
            }else {
                System.out.println("Your book isn't correct or not exist");
            }
        }
    }

