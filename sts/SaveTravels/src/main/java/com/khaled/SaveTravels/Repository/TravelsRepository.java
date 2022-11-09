package com.khaled.SaveTravels.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khaled.SaveTravels.model.Travelsmodel;


@Repository
public interface TravelsRepository extends CrudRepository<Travelsmodel , Long> {
	List<Travelsmodel> findAll();
//	List<Travelsmodel> findByDescriptionContaining(String search);
	Optional<Travelsmodel> findById(Long Id);
    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
    Long deleteById(Integer id);

}
