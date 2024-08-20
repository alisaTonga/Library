package de.ait.library.app.repository;


import de.ait.library.app.entity.Book;

import java.util.List;

public interface BookRepositoryInterface {
    List<Book> findAll();
    Book deleteBookById(Long id);
    Book save(Book book);


}
