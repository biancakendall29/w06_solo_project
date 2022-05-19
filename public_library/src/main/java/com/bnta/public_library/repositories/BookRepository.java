package com.bnta.public_library.repositories;

import com.bnta.public_library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByCopies(int copies);

}
