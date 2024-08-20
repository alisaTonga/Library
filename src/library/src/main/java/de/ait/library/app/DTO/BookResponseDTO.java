package de.ait.library.app.DTO;

import de.ait.library.app.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private String isbn13;

    public BookResponseDTO(Long id, String title, String author, Integer year, String isbn13) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn13 = isbn13;
    }

    public BookResponseDTO() {
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
    public static BookResponseDTO of(Book book) {
        return new BookResponseDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.getIsbn13());
    }

    public static List<BookResponseDTO> of(List<Book> books) {
        return books.stream()
                .map(b-> BookResponseDTO.of(b))
                .toList();
    }
}
