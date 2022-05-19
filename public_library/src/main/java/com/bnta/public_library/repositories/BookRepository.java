package com.bnta.public_library.repositories;

import com.bnta.public_library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
