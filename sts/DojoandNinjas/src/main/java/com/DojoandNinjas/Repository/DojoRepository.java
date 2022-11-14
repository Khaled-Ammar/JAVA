package com.DojoandNinjas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DojoandNinjas.model.Dojo;

@Repository
public interface DojoRepository extends CrudRepository <Dojo,Long> {
	List<Dojo> findAll();
//    List<Lang> findByName(String search);
//    Long countByNameContaining(String search);
//    Long deleteByNameStartingWith(String search);

}
