package com.Exam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.Exam.Reposetroy.ExamRepo;
import com.Exam.Reposetroy.Reposetroys;
import com.Exam.model.Exam;
import com.Exam.model.Login;
import com.Exam.model.User;



@Service
public class Services {
	@Autowired
	Reposetroys repositorys;
    @Autowired
    ExamRepo examRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	
    	Optional<User> opuser = repositorys.findByEmail(newUser.getEmail());
    	if(opuser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");

    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return repositorys.save(newUser);
    	
    }
    public User login(Login newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = repositorys.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    public User findUser(Long id) {
		Optional<User> user = repositorys.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
    public Exam findExam(Long id) {
		Optional<Exam> Exam = examRepo.findById(id);
		if(Exam.isPresent()) {
			return Exam.get();
		}
		else {
			return null;
		}
    }
	
    public List<Exam> findAll(){
		return examRepo.findAll();
	}
	public Exam createExam(Exam exam) {
		return examRepo.save(exam);
	}
	
	 public void deleteExam(Long id) {
	  	   Optional<Exam> ex = examRepo.findById(id);
	         if(ex.isPresent()) {
	        	 examRepo.deleteById(id);
	         }
	  }
	 public void addBorrower(Exam exam, User user) {
			exam.setUserprow(user);
			examRepo.save(exam);
		}
	 
	 public void deleteBorrower(Exam exam, User user) {
			exam.setUserprow(user);;
			examRepo.save(exam);
		}
	 
	 
	 public List<Exam> ExamBrrow(User user){
			return examRepo.findAllByUser(user);
		}
	 public List<Exam> unborrowedExams(User user){
			return examRepo.findByBorrow_idIsOrUser_idIs(null, user.getId());
		}
	 
	 public List<Exam> ExamBrrow2(User user){
			return examRepo.findByBorrow_idIs(user.getId());
		}
	 
	 public List<Exam> notExamBrrow(User user){
			return examRepo.findByBorrow_idNotContains(user.getId());
		}
	 public List<Exam> AllExamNoBorrow(User user){
			return examRepo.AllExamNoBorrow(user.getId());
		}
	 
	 public List<Exam> findByBorrowNull(){
		 return examRepo.findByBorrowNull();
	 }
    
}
