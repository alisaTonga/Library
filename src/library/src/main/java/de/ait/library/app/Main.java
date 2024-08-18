package de.ait.library.app;

import de.ait.library.app.entity.Book;
import de.ait.library.app.repository.BookRepositoryJDBC;
import de.ait.library.app.repository.JDBC;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource; // our data in resources
        JdbcTemplate jdbcTemplate; //
        JDBC.LoadDriver();
        List<Book> books = JDBC.getAllBooks();
        System.out.println("All books: ");
        System.out.println(books);
        JDBC repo = new JDBC();
        repo.addNewBook(new Book("title1", "author1", 2024, "isbn13"));
        books = JDBC.getAllBooks();
        System.out.println(books);
    }
}
