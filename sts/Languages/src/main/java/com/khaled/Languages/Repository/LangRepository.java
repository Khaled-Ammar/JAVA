package com.khaled.Languages.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khaled.Languages.model.Lang;


@Repository
public interface LangRepository extends CrudRepository <Lang , Long> {
	 List<Lang> findAll();
//	    List<Lang> findByName(String search);
//	    Long countByNameContaining(String search);
//	    Long deleteByNameStartingWith(String search);
	}

