package com.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.backend.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
