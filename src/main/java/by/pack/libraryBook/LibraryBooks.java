package by.pack.libraryBook;

import by.pack.dao.HibernateBookDao;
import by.pack.entity.Book;
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
                        String genre = data[3];
                        Book book = new Book(nameBook, nameAuthor, lastNameAuthor, genre);
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
