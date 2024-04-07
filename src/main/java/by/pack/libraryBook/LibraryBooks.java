package by.pack.libraryBook;

import by.pack.dao.HibernateBookDao;
import by.pack.entity.Book;
import by.pack.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class LibraryBooks {

    @Autowired
    private HibernateBookDao hibernateBookDao;


    public void saveBook() {
        File file = new File("G:\\JDK\\BookStore\\src\\main\\java\\by\\pack\\libraryBook\\Bookfile");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] data = line.split(",");
                    if (data.length >= 4) {
                        String nameBook = data[0];
                        String nameAuthor = data[1];
                        String lastNameAuthor = data[2];
                        Genre genre = null;
                        Book book = new Book(nameBook, nameAuthor, lastNameAuthor, genre);
                        System.out.println(book);
                        hibernateBookDao.save(book);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();


            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
