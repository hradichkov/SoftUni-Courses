package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        String lastName = scanner.nextLine();
//        int num = Integer.parseInt(scanner.nextLine());

//        List<Integer> input = Arrays.stream(scanner.nextLine().split("-"))
//                .map(Integer::parseInt)
//                .toList();

//        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALLlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
//
//        printAllBooksByAgeRestriction(input);
//
//        printAllGoldenBooksWithLessThan5000Copies();
//
//        printAllBooksWithPriceLessThan5AndMoreThan40();
//
//        printAllBooksThatAreNotIn(year);
//
//        printAllBooksReleasedBefore(input);
//
//        printAllAuthorsWithLastNameEndingWith(input);
//        printAllBooksWithTitleContaining(input);

//        printAllBooksWithAuthorLastNameStartingWith(input);

//        printCountOfBooksWithTitleLongerThan(num);

//        printCountOfCopiesByAuthor(firstName,lastName);

//        printBookByTitle(input);

//        printTotalNumbersOfAddedBooks(input, num);

//        printTotalNumberOfDeletedBooksWithCopiesLessThan(num);
    }

    private void printTotalNumberOfDeletedBooksWithCopiesLessThan(Integer copies) {
        System.out.println(this.bookService.deleteBookByCopiesLessThan(copies));
    }

    private void printTotalNumbersOfAddedBooks(String date, int copies) {
        DateTimeFormatter dtf = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd MMM yyyy")
                .toFormatter(Locale.ENGLISH);

        LocalDate parsedDate = LocalDate.parse(date, dtf);

        int count = this.bookService.increaseBookCopies(copies, parsedDate);

        System.out.println(count * copies);
    }

    private void printBookByTitle(String title) {
        System.out.println(this.bookService.findFirstByTitle(title).toString());
    }

    private void printCountOfCopiesByAuthor(String firstName, String lastName) {
        System.out.println(this.bookService.countAllCopiesByAuthor(firstName, lastName));
    }

    private void printCountOfBooksWithTitleLongerThan(int num) {
        System.out.println(this.bookService.countAllByTitleSizeGreaterThan(num));
    }

    private void printAllBooksWithAuthorLastNameStartingWith(String input) {
        this.bookService.findAllByAuthorLastNameStartingWith(input)
                .forEach(System.out::println);
    }

    private void printAllBooksWithTitleContaining(String input) {
        this.bookService.findAllByTitleContains(input.toLowerCase())
                .forEach(System.out::println);
    }

    private void printAllAuthorsWithLastNameEndingWith(String end) {
        this.authorService.findAllByFirstNameEndingWith(end.toLowerCase())
                .forEach(System.out::println);
    }

    private void printAllBooksReleasedBefore(List<Integer> input) {
        this.bookService.findAllBooksWithReleaseDateBefore(LocalDate.of(input.get(2), input.get(1), input.get(0)))
                .forEach(System.out::println);
    }

    private void printAllBooksThatAreNotIn(Integer year) {
        this.bookService.findAllByReleaseDateNot(LocalDate.of(year, 1, 1))
                .forEach(System.out::println);
    }

    private void printAllBooksWithPriceLessThan5AndMoreThan40() {
        this.bookService.findAllByPriceLessThanAndPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(System.out::println);
    }

    private void printAllGoldenBooksWithLessThan5000Copies() {
        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void printAllBooksByAgeRestriction(String input) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());

        bookService.findAllByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }


    private void printALLlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
