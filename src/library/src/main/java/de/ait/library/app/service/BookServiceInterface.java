package de.ait.library.app.service;


import de.ait.library.app.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    Book deleteBookById(Long id);
    List<Book> findAll();
    List<Book> findBook(String title, String author, String isbn);
    Book findBookById(Long id);
    Book addNewBook(Book book);
    Book updateBook (Book book);
}
