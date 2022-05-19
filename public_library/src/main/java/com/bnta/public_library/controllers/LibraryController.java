package com.bnta.public_library.controllers;

import com.bnta.public_library.models.Book;
import com.bnta.public_library.models.Library;
import com.bnta.public_library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("libraries")
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Library>> getLibrary() {
        return new ResponseEntity(libraryRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibrary(@PathVariable Long id) {
        var found = libraryRepository.findById(id);
        return new ResponseEntity(found, found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<Book> createLibrary(@RequestBody Library newLibrary) {
        libraryRepository.save(newLibrary);
        return new ResponseEntity(newLibrary, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Library>> deleteLibrary(@PathVariable Long id) {
        var found = libraryRepository.findById(id);
        libraryRepository.deleteById(id);
        return new ResponseEntity(libraryRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
    }

}
