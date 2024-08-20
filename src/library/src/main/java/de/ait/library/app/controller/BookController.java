package de.ait.library.app.controller;


import de.ait.library.app.DTO.BookRequestDTO;
import de.ait.library.app.DTO.BookResponseDTO;
import de.ait.library.app.service.BookService;
import de.ait.library.app.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-Library")
public class BookController {
    private final BookServiceInterface service;
    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books/{id}")
    public BookResponseDTO getBookById(@PathVariable(name = "id") Long id){
        return service.findBookById(id);
    }
//
    @GetMapping("/books")
    public List<BookResponseDTO> getBooks(@RequestParam (name= "a", required = false, defaultValue = "") String author,
                                          @RequestParam (name= "t", required = false, defaultValue = "") String title,
                                          @RequestParam (name= "y",  required = false, defaultValue = "") String year,
                                          @RequestParam (name= "isbn13", required = false, defaultValue = "") String isbn13) {

        Integer yearInt = year != null && !year.isEmpty() ? Integer.parseInt(year) : null;
        return service.getBook(title, author, yearInt, isbn13);
    };
    @PostMapping("/books")
    public BookResponseDTO addNewBook(@RequestBody BookRequestDTO book){
        return service.addNewBook(book);
    }

    @DeleteMapping("/books/{id}")
    public BookResponseDTO deleteBookById(@PathVariable(name = "id") Long id){
        return service.deleteBookById(id);
    }

    @PutMapping("/books/{id}")
    public BookResponseDTO updateBookById(@PathVariable(name="id") Long id, @RequestBody BookRequestDTO bookDto){
        return service.updateBook(id, bookDto );
    }
}
