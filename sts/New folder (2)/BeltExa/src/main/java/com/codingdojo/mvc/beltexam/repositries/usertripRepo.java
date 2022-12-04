package com.codingdojo.mvc.beltexam.repositries;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.beltexam.models.User;
import com.codingdojo.mvc.beltexam.models.usertrips;


@Repository
public interface usertripRepo extends CrudRepository<usertrips, Long> {
 usertrips findByuser(User user);
 List<usertrips> findAll();
}
