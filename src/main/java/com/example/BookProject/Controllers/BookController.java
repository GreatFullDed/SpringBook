package com.example.BookProject.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BookProject.*;

@Controller
public class BookController {

	@Autowired	
    private BookDao bookDao;
	
	@GetMapping("/book")
	public String listBook(Model model) throws IOException{
	    List<Book> listBooks = bookDao.listBooks();
	    model.addAttribute("listBooks", listBooks);
	    return ("book");
	}
	
	@GetMapping("/book/ReverseAlphabet")
	public String listBooksReverseAlphabet(Model model){
	    List<Book> listBooksReverseAlphabet = bookDao.listBooksReverseAlphabet();
	    model.addAttribute("listBooks", listBooksReverseAlphabet);
	    return ("book");
	}
	
	@GetMapping("/book/GroupByAuthor")
	public String listBooksGroupByAuthor(Model model) {
		List<Book> listBooksGroupByAuthor = bookDao.listBooksGroupByAuthor();
		model.addAttribute("listBooks",listBooksGroupByAuthor);
		return ("book");
	}
	
	@GetMapping("/book/add")
	public String addBook(Model model) {
	    return ("bookAdd");
	}
	
	@PostMapping("/book/add")
	public String addBookInDataBase(@RequestParam String title, @RequestParam String author, 
			@RequestParam String description,Model model) {
		Book book = new Book(title, author, description);
		bookDao.createBook(book);
	    return "redirect:/book";
	}

}
