package de.ait.library.app.repository;


import de.ait.library.app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        String query = "DELETE FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(query, bookRowMapper, id);
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            return create(book);
        }
        else{
            return update(book);
        }
    }

    private Book update(Book book) {
        String query = "UPDATE books SET title = ?, author = ?, year = ?, isnb13 = ? WHERE id= ?";
        int affectedRows = jdbcTemplate.update(query,  book.getTitle(), book.getAuthor(), book.getYear(), book.getIsbn13());
        return affectedRows ==1 ? book : null;
    }

    private Book create(Book book) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
        .usingGeneratedKeyColumns("id")
                .withTableName("books");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", book.getTitle());
        parameters.put("author", book.getAuthor());
        parameters.put("year", book.getYear());
        parameters.put("isbn13", book.getIsbn13());

        Long generatedId = jdbcInsert.executeAndReturnKey(parameters).longValue();
        book.setId(generatedId);
        return book;
    }


}
