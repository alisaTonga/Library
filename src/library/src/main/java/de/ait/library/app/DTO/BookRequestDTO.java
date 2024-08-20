package de.ait.library.app.DTO;

import de.ait.library.app.entity.Book;

public class BookRequestDTO {
    private String title;
    private String author;
    private Integer year;
    private String isbn13;

    public BookRequestDTO(String title, String author, Integer year, String isbn13) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn13 = isbn13;
    }

    public BookRequestDTO() {
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
    public static Book toEntity(BookRequestDTO bookRequestDTO) {
        return new Book(null, bookRequestDTO.getTitle(),
                bookRequestDTO.getAuthor(), bookRequestDTO.getYear(), bookRequestDTO.getIsbn13());
    }
}
