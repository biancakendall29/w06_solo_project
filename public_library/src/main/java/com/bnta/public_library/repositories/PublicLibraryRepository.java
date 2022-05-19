package com.bnta.public_library.repositories;

import com.bnta.public_library.models.PublicLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicLibraryRepository extends JpaRepository<PublicLibrary, Long> {}
