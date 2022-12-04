package com.PAC.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PAC.model.Categorie;
import com.PAC.model.Product;

@Repository
public interface CategoryRepo  extends CrudRepository<Categorie, Long>{
	List<Categorie> findAll();
	List<Categorie> findAllByProducts(Product product);

	List<Categorie> findByProductsNotContains(Product product);


}
