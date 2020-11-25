package com.bookstore.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.backend.entity.Book;
import com.bookstore.backend.entity.Category;
import com.bookstore.backend.service.BookService;
import com.bookstore.backend.service.CategoryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private CategoryService catService;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books){
		return service.saveBooks(books);
	}
	
	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return service.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book findBook(@PathVariable int id) {
		return service.getBook(id);
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return service.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return service.deleteBook(id);
	}
	
	@GetMapping("/categories")
	public List<Category> findAllCategories() {
		return catService.getCategories();
	}
	@GetMapping("/categoriesBooks")
	public List<Category> AllBooksWithCategories() {
		return catService.CatBook();
	}
}
