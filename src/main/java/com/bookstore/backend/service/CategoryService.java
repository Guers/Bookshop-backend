package com.bookstore.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.backend.entity.Category;
import com.bookstore.backend.repository.BookRepository;
import com.bookstore.backend.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repositoryCat;
	@Autowired
	private BookRepository repositoryBook;

	public List<Category> getCategories() {
		
		return repositoryCat.findAll();
	}
	public List<Category>CatBook(){
		List<Category> cats=getCategories();
		for(Category cat : cats) {
			cat.setBooks(repositoryBook.bookCat(cat));
		}
		
		return cats;
	}
}
