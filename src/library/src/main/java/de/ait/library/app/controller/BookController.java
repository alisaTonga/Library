package de.ait.library.app.controller;


import de.ait.library.app.entity.Book;
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
    public Book getBookById(@PathVariable(name = "id") Long id){
        return service.findBookById(id);
    }

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam (name= "a", required = false, defaultValue = "") String author,
                               @RequestParam (name= "t", required = false, defaultValue = "") String title,
                               @RequestParam (name= "isbn13", required = false, defaultValue = "") String isbn13) {
        return service.findBook(title, author, isbn13);
    };
    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book){
        return service.addNewBook(book);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBookById(@PathVariable(name = "id") Long id){
        return service.deleteBookById(id);
    }

}
