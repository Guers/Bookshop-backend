package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Book;
import repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> getBooks() {
		return repository.findAll();
		
	}

	public Book getBook(int id) {
		return repository.findById(id).orElse(null); 
		
	}
	
	public List<Book> saveBooks(List<Book> books) {
		return repository.saveAll(books);
	}
	
	public Book saveBook(Book book) {
		return repository.save(book);
	}
	
	public String deleteBook(int id) {
		repository.deleteById(id);
		return "Book removed "+id;
	}
	
	public Book updateBook(Book book) {
		Book existingBook =repository.findById(book.getBookId()).orElse(null);
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPicture(book.getPicture());
		existingBook.setPublicationYear(book.getPublicationYear());
		existingBook.setTitle(book.getTitle());
		
		return repository.save(existingBook);
	}
}
