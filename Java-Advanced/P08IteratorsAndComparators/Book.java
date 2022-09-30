package P08IteratorsAndComparators;

import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> author;

    public Book(String title, int year, String... author) {
        setTitle(title);
        setYear(year);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String... author) {
        this.author = List.of(author);
    }

    @Override
    public int compareTo(Book other) {
        int result = this.title.compareTo(other.title);

        if (result == 0) {
            result = Integer.compare(this.year, other.year);
        }

        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", author=" + author +
                '}';
    }
}
