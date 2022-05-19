package com.bnta.public_library.repositories;

import com.bnta.public_library.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {}
