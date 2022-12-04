package com.Exam.Reposetroy;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.Exam.model.Exam;
import com.Exam.model.User;

@Repository
public interface ExamRepo  extends CrudRepository<Exam, Long>{
	List<Exam> findAll();

    List<Exam> findAllByUser(User user);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Exam> findByUserNotContains(User user);
    List<Exam> findByBorrow_idIs(Long id);
    List<Exam> findByBorrow_idNotContains(Long id);
    List<Exam> findByBorrow_idIsOrUser_idIs(Long borrow_id,Long user_id);
//    List<Exam> findByBorrowNull();
    @Query(value="select * from Exams join users on Exams.user_id = users.id where ?1 !=  Exams.borrow_id", nativeQuery = true)
    List<Exam> AllExamNoBorrow(Long id);
}
