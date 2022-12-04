package com.Login.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Login.model.User;


@Repository
public interface Reposetroy extends CrudRepository<User, Long>{
 // this method retrieves all the books from the database
 List<User> findAll();
 Optional<User> findByEmail(String email);

 // this method finds books with descriptions containing the search string
 // this method counts how many titles contain a certain string
// Long countByTitleContaining(String search);
 // this method deletes a book that starts with a specific title
// Long deleteByTitleStartingWith(String search);
// public List<User> findByProductsNotContains(Products product);
 
}
