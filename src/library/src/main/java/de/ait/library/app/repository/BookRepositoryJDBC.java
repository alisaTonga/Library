package de.ait.library.app.repository;


import de.ait.library.app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookRepositoryJDBC implements BookRepositoryInterface{
    private final DataSource dataSource; // our data in resources
    private final JdbcTemplate jdbcTemplate; //
    private static RowMapper<Book> bookRowMapper = (row, rowNumber)->{
        Long id = row.getLong("id");
        String title = row.getString("title");
        String author = row.getString("author");
        Integer year = row.getInt("year");
        String isbn13 = row.getString("isbn13");
        return new Book(id,title,author, year, isbn13);
    };

    @Autowired
    public BookRepositoryJDBC(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> findAll() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, bookRowMapper);
    }

    @Override
    public Book deleteBookById(Long id) {
        String query = "DELETE * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(query, bookRowMapper, id);
    }

    @Override
    public Book findBookById(Long id) {
        String query = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(query, bookRowMapper, id);
    }
//
//    @Override
//    public Book findBookByTitle(String title) {
//        String query = "SELECT * FROM books WHERE title = ?";
//        return jdbcTemplate.queryForObject(query, bookRowMapper, title);
//    }
//
//    @Override
//    public List<Book> findBookByAuthor(String author) {
//        String query = "SELECT * FROM books WHERE author = ?";
//        return jdbcTemplate.query(query, bookRowMapper, author);
//
//    }
//
//    @Override
//    public Book findBookByIsbn(String isbn) {
//        String query = "SELECT * FROM books WHERE isbn = ?";
//        return jdbcTemplate.queryForObject(query, bookRowMapper, isbn);
//    }
}
