package by.pack.service;

import by.pack.dao.HibernateBookDao;
import by.pack.dto.BookDto;
import by.pack.entity.Book;
import by.pack.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private HibernateBookDao hibernateBookDao;

    public Book bookInfo;

    public void save(BookDto bookDto){
        Book book = BookMapper.bookDtoToBook(bookDto);
        hibernateBookDao.saveAddBook(book);
    }

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
                        String description = readAndSaveDescription();
                        bookInfo = new Book(nameBook, nameAuthor, lastNameAuthor, genre, description);
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

    public String readAndSaveDescription() {
        InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().
                getResourceAsStream("BookDescription")));
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String text = "";
            String line = String.valueOf(0);
            while ((line = bufferedReader.readLine()) != null) {
                if (!(line.trim().isEmpty())) {
                    text += line + " ";
                    bookInfo = new Book();
                    bookInfo.setDescription(text);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        return bookInfo.getDescription();
    }


//    public void saveDescriptionDemo(){
//        InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().
//                getResourceAsStream("BookDescription")));
//        try {
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String text= "";
//            String line;
//            Long id = Long.valueOf(0);
//            while ((line = bufferedReader.readLine()) != null){
//                if(!line.trim().isEmpty()){
//                    text += line + " ";
//                }else {
//                    Book book = hibernateBookDao.findByLineCount(++id);
//                    if(book != null){
//                        book.setDescription(text.trim());
//                        hibernateBookDao.update(book);
//                    }
//                    text = "";
//                }
//            }
//
//            if(!text.isEmpty()) {
//                Book book = hibernateBookDao.findByLineCount(++id);
//                if (book != null) {
//                    book.setDescription(text);
//                    hibernateBookDao.update(book);
//                }
//            }
//                    bufferedReader.close();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//        }
//    }
    public void addDescriptionToBook(Long id, String description){
        Book book = hibernateBookDao.findByLineCount(id);
        if(book != null){
            book.setDescription(description);
        }else {
            System.out.println("id or Book not found");
        }
    }

    public Optional<Book>findById(Long id){
        Book book = hibernateBookDao.findByLineCount(id);
        return Optional.ofNullable(book);
    }
}
