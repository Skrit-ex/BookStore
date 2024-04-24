package by.pack.service;

import by.pack.dao.HibernateBookDao;
import by.pack.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private HibernateBookDao hibernateBookDao;

    public Book bookInfo;

    public void saveBook() {
        InputStreamReader inputStreamReader = new InputStreamReader
                (Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BookFile")));

        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] data = line.split(",");
                    if (data.length >= 4) {
                        String nameBook = data[0];
                        String nameAuthor = data[1];
                        String lastNameAuthor = data[2];
                        String genre = data[3];
                        bookInfo = new Book(nameBook, nameAuthor, lastNameAuthor, genre);
                        hibernateBookDao.save(bookInfo);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDescription() {
        InputStreamReader inputStreamReader = new InputStreamReader
                (Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BookDescription")));

        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String text = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    text += line + "\n";
                } else {
                    Book book = new Book();
                    book.setDescription(text);
                    hibernateBookDao.save(book);
                    text = "";
                }
            }
            if (text.isEmpty()) {
                Book book = new Book();
                book.setDescription(text);
                hibernateBookDao.save(book);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
