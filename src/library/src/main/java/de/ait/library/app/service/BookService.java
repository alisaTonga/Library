package de.ait.library.app.service;


import de.ait.library.app.entity.Book;
import de.ait.library.app.repository.BookRepositoryJDBC;
import de.ait.library.app.repository.JDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class BookService implements BookServiceInterface{
    private final BookRepositoryJDBC bookRepository;
    private final JDBC jdbc = new JDBC();

    @Autowired
    public BookService(BookRepositoryJDBC bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book deleteBookById(Long id) {
        return bookRepository.deleteBookById(id);
    }

    @Override
    public Book addNewBook(Book book) {
        if (book.getId() != null){
            book.setId(null);
        }
        return jdbc.addNewBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        return jdbc.updateBook(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBook(String title, String author, String isbn) {
        Predicate<Book> predicateByTitle =
                (title.equals("")) ? a-> true : book -> book.getTitle().toLowerCase().contains(title.toLowerCase());

        Predicate<Book> predicateByAuthor =
                (author.equals("")) ? a-> true : book -> book.getAuthor().toLowerCase().contains(author.toLowerCase());

        Predicate<Book> predicateByIsbn =
                (isbn.equals("")) ? a-> true : book -> book.getISBN13().toLowerCase().contains(isbn.toLowerCase());


        Predicate<Book> allCondition = predicateByTitle.and(predicateByAuthor).and(predicateByIsbn);
        return bookRepository.findAll()
                .stream()
                .filter(allCondition)
                .toList();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

}
