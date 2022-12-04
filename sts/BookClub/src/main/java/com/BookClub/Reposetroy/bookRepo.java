package com.BookClub.Reposetroy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookClub.model.Book;

@Repository
public interface bookRepo extends CrudRepository<Book, Long>{

	 // this method retrieves all the books from the database
	 List<Book> findAll();
//	 Optional<User> findByEmail(String email);
	 
//	 List<Book> findByparowNotContains(Long id);
//	 List<Book> findByParow(boolean bul);
	 
	 // this method finds books with descriptions containing the search string
	 // this method counts how many titles contain a certain string
	// Long countByTitleContaining(String search);
	 // this method deletes a book that starts with a specific title
	// Long deleteByTitleStartingWith(String search);
	// public List<User> findByProductsNotContains(Products product);
	 
	}