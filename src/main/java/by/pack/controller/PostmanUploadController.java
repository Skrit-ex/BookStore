package by.pack.controller;

import by.pack.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
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
    public ResponseEntity<String> handleJsonAndMultipartInput(@RequestPart("data") Book book,
                                                              @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok()
                .body(book.getId() + book.getNameBook());
    }
}

//    @RequestMapping(value = "/uploadJson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> handleJsonInput(@RequestBody Book book) {
//        return ResponseEntity.ok().body(book.getNameBook());
//    }

