package com.example.BookProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BookDaoImpl implements BookDao {
	@Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    
    public BookDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createBook(Book book) {
        String SQL = "INSERT INTO Book (title, author, description) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, book.getTitle(), book.getAuthor(), book.getDescription());
    }

    @Override
    public List<Book> listBooks() {
        String SQL = "SELECT * FROM book";
        List<Book> books = jdbcTemplate.query(SQL, new BookMapper());
        return books;
    }
    
    @Override
    public List<Book> listBooksReverseAlphabet() {
        String SQL = "SELECT * FROM book ORDER BY title DESC";
        List<Book> books = jdbcTemplate.query(SQL, new BookMapper());
        return books;
    }
    
    @Override
    public List<Book> listBooksGroupByAuthor() {
        String SQL = "SELECT * FROM book group by author";
        List<Book> books = jdbcTemplate.query(SQL, new BookMapper());
        return books;
    }
}