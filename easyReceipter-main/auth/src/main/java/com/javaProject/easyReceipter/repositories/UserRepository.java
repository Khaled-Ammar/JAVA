package com.javaProject.easyReceipter.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaProject.easyReceipter.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
 
}


