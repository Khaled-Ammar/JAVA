package com.codingdojo.mvc.beltexam.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.beltexam.models.Trip;


@Repository
public interface TripRepo extends CrudRepository<Trip, Long> {

	List<Trip> findAll();
//	List<Trip> findByUsersNotContains(User user);
	
//	List<Event> findBylocation(String loc);
//	@Query(value="select * from evnets order by avg_rate desc limit 10",nativeQuery = true)
//	List<Event> TopRate();
}
