package by.pack.controller;

import by.pack.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PostmanUploadController {

    @PostMapping("/uploadFile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok()
                .body("file received successfully");
    }

    @PostMapping("/uploadJson")
    public ResponseEntity<String> handleJsonInput(@RequestBody Book book) {
        return ResponseEntity.ok()
                .body(book.getNameBook());
    }

    @PostMapping("/uploadJsonAndMultipartData")
    public ResponseEntity<String> handleJsonAndMultipartInput(@RequestPart("data") Book book, @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok()
                .body(book.getId() + book.getNameBook());
    }
}