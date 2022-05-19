package com.bnta.public_library.repositories;

import com.bnta.public_library.models.Public_library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicLibraryRepository extends JpaRepository<Public_library, Long> {}
