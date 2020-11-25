package com.bookstore.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.backend.entity.Book;
import com.bookstore.backend.entity.Category;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("select b from Book b where b.category=:c")
	public List<Book> bookCat(@Param("c")Category cat);

	
}
