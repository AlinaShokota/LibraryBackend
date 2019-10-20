package com.library.service;

import com.library.exception.NoSuchBookException;
import com.library.model.Book;
import com.library.repository.BookRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger LOGGER = LogManager.getLogger(BookService.class.getName());

    @Autowired
    private BookRepo bookRepo;

    public void addBook(Book book){
        bookRepo.save(book);
        LOGGER.info("Book has been added to database");
    }

    public void updateBook(Book book){
        bookRepo.save(book);
        LOGGER.info("Book has been updated");
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public List<Book> getAllAvailableBooks(){
        return bookRepo.findAllAvailableBooks();
    }

    public Book getBookById(int id){
        return bookRepo.findById(id).get();
    }

    public void deleteBook(int id){
        bookRepo.deleteById(id);
        LOGGER.info("Book with id="+id+" has been deleted from database");
//        bookRepo.findById(id).ifPresentOrElse(book -> {
//            bookRepo.deleteById(id);
//            LOGGER.info("Book with id="+id+" has been deleted from database");
//        }, () -> {
//            LOGGER.error("NO BOOK FOUND WITH ID="+ id);
//            throw new NoSuchBookException("No book found with id="+ id);
//        });
    }
}
