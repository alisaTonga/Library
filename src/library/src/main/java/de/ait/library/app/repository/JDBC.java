//package de.ait.library.app.repository;
//
//
//import de.ait.library.app.entity.Book;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JDBC implements BookRepoCreate_Update {
//    private static final String DRIVER = "org.postgresql.Driver";
//    private static final String URL ="jdbc:postgresql://localhost:5432/";
//    private static final String DB = "My_Library";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "qwerty007";
//
//    public static void LoadDriver() {
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Load driver error: " + DRIVER);
//        }
//    }
//
//    public static Connection getConnection() {
//        try {
//            Connection connection = DriverManager.getConnection(URL+DB, USERNAME, PASSWORD);
//            return connection;
//        } catch (SQLException e) {
//            throw new RuntimeException("Create connection fail!");
//        }
//    }
//
//    public static List<Book> getAllBooks() {
//        String query = "SELECT * FROM books";
//        try(Connection connection = getConnection()) {
//            if (connection==null){
//                throw new SQLException("Connect fail");
//            }
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            List<Book> result = new ArrayList<Book>();
//            while (resultSet.next()) {
//                Long id = resultSet.getLong("id");
//                String title = resultSet.getString("title");
//                String author = resultSet.getString("author");
//                Integer year = resultSet.getInt("year");
//                String ISBN13 = resultSet.getString("ISBN13");
//                result.add(new Book(id, title, author, year, ISBN13));
//            }
//            return result;
//        } catch (SQLException e) {
//            throw new RuntimeException("Get all books fail!");
//        }
//
//    };
//
//    @Override
//    public Book addNewBook(Book book) {
//        String query = "INSERT INTO books (title, author, year, isbn13) VALUES (?, ?, ?, ?)";
//        try (Connection connection = getConnection()){
//            if (connection==null){
//                throw new SQLException("Connect fail");
//            }
//            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//
//            statement.setString(1, book.getTitle());
//            statement.setString(2, book.getAuthor());
//            statement.setInt(3, book.getYear());
//            statement.setString(4, book.getISBN13());
//            int affectedRows = statement.executeUpdate();
//            if (affectedRows == 0) {
//                throw new SQLException("Create user fail!");
//            }
//
//            ResultSet resultSet = statement.getGeneratedKeys();
//            if (!resultSet.next()){
//                throw new SQLException("Get new book id fail!");
//            }
//            else {
//                Long id = resultSet.getLong(1);
//                book.setId(id);
//                return book;
//            }
//        }
//        catch (SQLException e) {
//            throw new RuntimeException("Add new book fail!" + e);
//        }
//    }
//
//    @Override
//    public Book updateBook(Book book) {
//        String query = "UPDATE books SET title = ?, author = ?, year = ?, isbn13 = ? WHERE id = ?";
//        try (Connection connection = getConnection()){
//            if (connection==null){
//                throw new SQLException("Connect fail");
//            }
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, book.getTitle());
//            statement.setString(2, book.getAuthor());
//            statement.setInt(3, book.getYear());
//            statement.setString(4, book.getISBN13());
//            statement.setLong(5, book.getId());
//
//            int affectedRows = statement.executeUpdate();
//            if (affectedRows == 0) {
//                throw new SQLException("Book with id " + book.getId() + " does not exist!");
//            }
//            if (affectedRows == 1) {
//                throw new SQLException("Error! Updated "+ affectedRows + "books. Duplicate key in DB");
//            }
//            return book;
//        }
//        catch (SQLException e){
//            throw new RuntimeException("Update book fail!");
//        }
//    }
//
//}
