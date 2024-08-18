package de.ait.library.app.repository;


import de.ait.library.app.entity.Book;

public interface BookRepoCreate_Update {
    Book addNewBook(Book book);
    Book updateBook (Book book);

}
