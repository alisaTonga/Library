package de.ait.library.app.entity;
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private String isbn13;

    public Book(Long id, String title, String author, Integer year, String isbn13) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn13 = isbn13;
    }

    public Book() {
    }

    public Book(String title, String author, Integer year, String isbn13) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn13 = isbn13;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isbn13='" + isbn13 + '\'' +
                '}';
    }
}
