package de.ait.library.app.service;


import de.ait.library.app.DTO.BookRequestDTO;
import de.ait.library.app.DTO.BookResponseDTO;
import de.ait.library.app.entity.Book;
import de.ait.library.app.repository.BookRepositoryJDBC;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class BookService implements BookServiceInterface{
    private final BookRepositoryJDBC bookRepository;
    private final ModelMapper mapper;

    @Autowired
    public BookService(BookRepositoryJDBC bookRepository,
                       ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookResponseDTO> findAll() {
        List<Book> bookList = bookRepository.findAll();
        return BookResponseDTO.of(bookList);
    }

    @Override
    public BookResponseDTO findBookById(Long id) {
        return findAll()
                .stream()
                .filter(b->b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public BookResponseDTO deleteBookById(Long id) {
        Book book = bookRepository.deleteBookById(id);
        return mapper.map(book, BookResponseDTO.class);
    }

    @Override
    public BookResponseDTO addNewBook(BookRequestDTO bookDto) {
        Book book = bookRepository.save(mapper.map(bookDto, Book.class));
        return mapper.map(book, BookResponseDTO.class);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO bookDTO) {
        Book book1 = bookRepository.save(mapper.map(bookDTO,Book.class));
        return mapper.map(book1, BookResponseDTO.class);
    }



    @Override
    public List<BookResponseDTO> getBook(String title, String author,Integer year,  String isbn13) {
        List<Book> bookList = bookRepository.findAll();

        Predicate<Book> predicateByTitle = (title == null || title.isEmpty())
                ? book -> true
                : book -> book.getTitle().toLowerCase().contains(title.toLowerCase());

        Predicate<Book> predicateByAuthor = (author == null || author.isEmpty())
                ? book -> true
                : book -> book.getAuthor().toLowerCase().contains(author.toLowerCase());

//        Predicate<Book> predicateByYear = (year == null)
//                ? book -> true
//                : book -> Objects.equals(book.getYear(), year);
        Predicate<Book> predicateByYear = year == null ? b -> true : b -> b.getYear().equals(year);

        Predicate<Book> predicateByIsbn = (isbn13 == null || isbn13.isEmpty())
                ? book -> true
                : book -> book.getIsbn13().toLowerCase().contains(isbn13.toLowerCase());

        Predicate<Book> allCondition = predicateByTitle
                .and(predicateByAuthor)
                .and(predicateByYear)
                .and(predicateByIsbn);

        List<Book> filteredBooks = bookList.stream()
                .filter(allCondition)
                .toList();

        return BookResponseDTO.of(filteredBooks);
    }
}
