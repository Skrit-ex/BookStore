package by.pack.controller;

import by.pack.dao.HibernateBookDao;
import by.pack.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@RestController
public class FileController {

    @Autowired
    private HibernateBookDao hibernateBookDao;

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null){

                String[] data = line.split(",");
                if (data.length >= 2) {
                    String nameBook = data[0];
                    String nameAuthor = data [1];
                    String lastNameAuthor = data [2];
                    String genre = data [3];
                    Book book = new Book(nameBook,nameAuthor,lastNameAuthor,genre);
                    hibernateBookDao.save(book);
                }
            }
            bufferedReader.close();
            return "file successfully downloaded";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
