package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/save")
    public ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
