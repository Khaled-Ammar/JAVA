package com.DojoandNinjas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DojoandNinjas.model.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja , Long> {

	List<Ninja> findAll();
//    List<Lang> findByName(String search);
//    Long countByNameContaining(String search);
//    Long deleteByNameStartingWith(String search);
}
