package com.bnta.public_library.repositories;

import com.bnta.public_library.models.Book;
import com.bnta.public_library.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByNameStartingWith(String prefix);

}
