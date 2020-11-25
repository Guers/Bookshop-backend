package com.bookstore.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
