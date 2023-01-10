package com.example.bookshop;

import com.example.bookshop.services.author.AuthorService;
import com.example.bookshop.services.book.BookService;
import com.example.bookshop.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final LocalDate BOOK_YEAR_AFTER = LocalDate.of(2000, 1, 1);
    private final LocalDate BOOK_YEAR_BEFORE = LocalDate.of(1990, 1, 1);

    private final String AUTHOR_FIRST_NAME = "George";
    private final String AUTHOR_LAST_NAME = "Powell";

    private final SeedService seedService;
    private final BookService bookService;

    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
       // this.seedService.seedAllData();
       // this.getAllBookAfterAGivenYear();
       // this.getAllAuthorsWithBooksReleaseDateBefore();
        this.getAllAuthorsOrderByBooksCount();
       // this.getAllBooksFromAuthor();
    }

    private void getAllBookAfterAGivenYear() {
        this.bookService
                .findAllByReleaseDateAfter(BOOK_YEAR_AFTER)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void getAllAuthorsWithBooksReleaseDateBefore() {
        this.authorService
                .findDistinctByBooksBefore(BOOK_YEAR_BEFORE)
                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }

    private void getAllAuthorsOrderByBooksCount() {
        this.authorService.findAllDistinctOrderByBooks()
                .forEach(author -> System.out.println(author.toStringWithCount()));
    }

    private void getAllBooksFromAuthor() {
        this.bookService
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME)
                .forEach(b -> System.out.println(
                        b.getTitle() + " " + b.getReleaseDate() + " " + b.getCopies()));
    }
}
