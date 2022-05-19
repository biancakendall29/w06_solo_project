package com.bnta.public_library;

import com.bnta.public_library.models.Book;
import com.bnta.public_library.models.Member;
import com.bnta.public_library.repositories.BookRepository;
import com.bnta.public_library.repositories.MemberRepository;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PublicLibraryApplicationTests {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	MemberRepository memberRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindBooksByCopies() {
		List<Book> found = bookRepository.findByCopiesGreaterThanEqual(4);
		assertThat(found.size()).isEqualTo(4);
	}

	@Test
	public void canFindBookSizeByMember() {
		List<Member> found = memberRepository.findByNameStartingWith("B");
		assertThat(found.size()).isEqualTo(2);
	}

}
