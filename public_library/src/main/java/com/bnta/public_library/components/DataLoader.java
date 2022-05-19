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


        Member member1 = new Member("Ash");
        Member member2 = new Member("Bianca");
        Member member3 = new Member("Bruce");
        Member member4 = new Member("Erin");
        memberRepository.saveAll(Arrays.asList(member1, member2, member3, member4));

        Book book1 = new Book("The Night Circus", "Erin Morgenstern", library1, Arrays.asList(member2, member4));
        Book book2 = new Book("Lord of the Rings: The Fellowship of the Ring", "JRR Tolkein", library1, Arrays.asList(member1, member2, member3, member4));
        Book book3 = new Book("Lord of the Rings: The Two Towers", "JRR Tolkein", library1, Arrays.asList(member2));
        Book book4 = new Book("Lord of the Rings: The Return of the King", "JRR Tolkein", library1, Arrays.asList(member2));
        Book book5 = new Book("Dune", "Frank Herbert", library1, Arrays.asList(member2));
        Book book6 = new Book("Angels and Demons", "Dan Brown", library1, Arrays.asList(member2));
        Book book7 = new Book("Blink", "Malcolm Gladwell", library1, Arrays.asList(member2));
        Book book8 = new Book("Sapiens", "Yuval Noah Harari", library1, Arrays.asList(member2));
        Book book9 = new Book("The Power of One", "Bryce Courtenay", library1, Arrays.asList(member2));
        Book book10 = new Book("Peacocks in the Mist", "Sandra Kendall", library1, Arrays.asList(member2));
        Book book11 = new Book("Mao's Last Dancer", "Li Cunxin", library2, Arrays.asList(member2));
        Book book12 = new Book("Americanah", "Chimamanda Ngozi Adichie", library2, Arrays.asList(member2));
        Book book13 = new Book("A Thousand Splendid Suns", "Khaled Hosseini", library2, Arrays.asList(member2));
        Book book14 = new Book("The Secret Life of Bees", "Sue Monk Kidd", library2, Arrays.asList(member2));
        Book book15 = new Book("The Sandman", "Lars Kepler", library2, Arrays.asList(member2));
        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10,
                book11, book12, book13, book14, book15));

    }
}
