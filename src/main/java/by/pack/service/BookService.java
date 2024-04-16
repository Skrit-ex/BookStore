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
                        Book book = new Book(nameBook, nameAuthor, lastNameAuthor, genre);
                        System.out.println(book);
                        hibernateBookDao.save(book);
                        //inputStreamReader.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
