package com.example.BookProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idBook;
	private String title;
	private String author;
	private String description;

	public Book() {
		
	}
	
	public Book(String title, String author, String description) {
		 this.setAuthor(author);
		 this.setDescription(description);
		 this.setTitle(title);
	}
	
	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return idBook + ", " + title + ", " + author + ", " + description;
	}
}

