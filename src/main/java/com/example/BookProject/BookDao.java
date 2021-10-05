package com.example.BookProject;

import javax.sql.DataSource;

import java.util.List;

public interface BookDao {
	
    public void setDataSource(DataSource dataSource);

    public void createBook(Book book);

    public List<Book> listBooks();
    
    public List<Book> listBooksReverseAlphabet();
    
    public List<Book> listBooksGroupByAuthor();
}