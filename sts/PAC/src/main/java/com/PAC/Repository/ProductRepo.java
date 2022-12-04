package com.PAC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PAC.model.Categorie;
import com.PAC.model.Product;


@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findAllByCategories(Categorie cat);
	@Query(value="select categories_products.id,categories.name from products  join categories_products on products.id= categories_products.product_id join categories on categories_products.category_id=categories.id where products.id=?1",nativeQuery = true)
	List<Product> findByCategoriesNotContains(Categorie cat);

}
