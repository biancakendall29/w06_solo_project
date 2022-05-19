package com.bnta.public_library.components;

import com.bnta.public_library.models.Book;
import com.bnta.public_library.models.Library;
import com.bnta.public_library.models.Member;
//import com.bnta.public_library.models.PublicLibrary;
import com.bnta.public_library.repositories.BookRepository;
import com.bnta.public_library.repositories.LibraryRepository;
import com.bnta.public_library.repositories.MemberRepository;
//import com.bnta.public_library.repositories.PublicLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Library library1 = new Library("Beacock Branch Library");
        libraryRepository.save(library1);
        Library library2 = new Library("Central Library");
        libraryRepository.save(library2);

        Member member1 = new Member("Ash", LocalDate.of(1998, 5, 24));
        Member member2 = new Member("Bianca", LocalDate.of(1999, 10, 29));
        Member member3 = new Member("Bruce", LocalDate.of(2002, 9, 18));
        Member member4 = new Member("Erin", LocalDate.of(1999, 7, 19));
        memberRepository.saveAll(Arrays.asList(member1, member2, member3, member4));

        Book book1 = new Book("The Night Circus", "Erin Morgenstern", 3, library1, Arrays.asList(member2, member4));
        Book book2 = new Book("Lord of the Rings: The Fellowship of the Ring", "JRR Tolkein", 1, library1, Arrays.asList(member1));
        Book book3 = new Book("Lord of the Rings: The Two Towers", "JRR Tolkein", 1, library1, Arrays.asList(member1));
        Book book4 = new Book("Lord of the Rings: The Return of the King", "JRR Tolkein", 1, library1, Arrays.asList(member1));
        Book book5 = new Book("Dune", "Frank Herbert", 2, library1, Arrays.asList(member3));
        Book book6 = new Book("Angels and Demons", "Dan Brown", 5, library1, Arrays.asList(member2, member3));
        Book book7 = new Book("Blink", "Malcolm Gladwell", 2, library1, Arrays.asList(member1));
        Book book8 = new Book("Sapiens", "Yuval Noah Harari", 4, library1, Arrays.asList(member4));
        Book book9 = new Book("The Power of One", "Bryce Courtenay", 1, library1, Arrays.asList(member2));
        Book book10 = new Book("Peacocks in the Mist", "Sandra Kendall", 4, library1, Arrays.asList(member1, member2, member3, member4));
        Book book11 = new Book("Mao's Last Dancer", "Li Cunxin", 2, library2, Arrays.asList());
        Book book12 = new Book("Americanah", "Chimamanda Ngozi Adichie", 6, library2, Arrays.asList(member1, member2, member4));
        Book book13 = new Book("A Thousand Splendid Suns", "Khaled Hosseini", 3, library2, Arrays.asList(member2, member4));
        Book book14 = new Book("The Secret Life of Bees", "Sue Monk Kidd", 2, library2, Arrays.asList(member2, member4));
        Book book15 = new Book("The Sandman", "Lars Kepler", 1, library2, Arrays.asList(member3));
        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10,
                book11, book12, book13, book14, book15));

    }
}
