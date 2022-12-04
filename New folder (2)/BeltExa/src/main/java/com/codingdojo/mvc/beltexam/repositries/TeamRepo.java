package com.codingdojo.mvc.beltexam.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.beltexam.models.Team;

@Repository
public interface TeamRepo extends CrudRepository<Team, Long> {

	List<Team> findAll();
//	List<Team> findByUsersNotContains(User user);
}
