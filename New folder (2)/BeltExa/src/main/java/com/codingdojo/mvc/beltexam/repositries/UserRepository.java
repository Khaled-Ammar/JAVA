package com.codingdojo.mvc.beltexam.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.beltexam.models.Team;
import com.codingdojo.mvc.beltexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
	List<User> findAll();
	List<User> findByteamsNotContains(Team team);

}
