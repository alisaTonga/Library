package de.ait.library.app.entity;

public class Book {
    private Long id;
    private String title;
    private String Author;
    private Integer year;
    private String ISBN13;

    public Book(Long id, String title, String author, Integer year, String ISBN13) {
        this.id = id;
        this.title = title;
        Author = author;
        this.year = year;
        this.ISBN13 = ISBN13;
    }

    public Book(String title, String author, Integer year, String ISBN13) {
        this.title = title;
        Author = author;
        this.year = year;
        this.ISBN13 = ISBN13;
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
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String ISBN13) {
        this.ISBN13 = ISBN13;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", year=" + year +
                ", ISBN13='" + ISBN13 + '\'' +
                '}';
    }
}
