package com.bnta.public_library.controllers;

import com.bnta.public_library.models.Book;
import com.bnta.public_library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Book>> getBooksAndFilters(@RequestParam(required = false, name="copies") Integer copies) {
        if (copies != null) {
            return new ResponseEntity(bookRepository.findByCopiesGreaterThanEqual(copies), HttpStatus.OK);
        }
        return new ResponseEntity(bookRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        var found = bookRepository.findById(id);
        return new ResponseEntity(found, found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        bookRepository.save(newBook);
        return new ResponseEntity(newBook, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Book>> deleteBook(@PathVariable Long id) {
        var found = bookRepository.findById(id);
        bookRepository.deleteById(id);
        return new ResponseEntity(bookRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
    }



}
