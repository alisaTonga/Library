package de.ait.library.app.service;


import de.ait.library.app.DTO.BookRequestDTO;
import de.ait.library.app.DTO.BookResponseDTO;
import de.ait.library.app.entity.Book;

import java.util.List;

public interface BookServiceInterface {
    BookResponseDTO deleteBookById(Long id);
    List<BookResponseDTO> findAll();
    List<BookResponseDTO> getBook(String title, String author,Integer year, String isbn);
    BookResponseDTO findBookById(Long id);
    BookResponseDTO addNewBook(BookRequestDTO book);
    BookResponseDTO updateBook (Long id, BookRequestDTO  book);
}
