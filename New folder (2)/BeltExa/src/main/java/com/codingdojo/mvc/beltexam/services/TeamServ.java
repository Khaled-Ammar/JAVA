package com.codingdojo.mvc.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.beltexam.models.Team;
import com.codingdojo.mvc.beltexam.repositries.TeamRepo;

@Service
public class TeamServ {
	@Autowired
	TeamRepo teamRepo;

	 public Team findTeam(Long id) {
			Optional<Team> book = teamRepo.findById(id);
			if(book.isPresent()) {
				return book.get();
			}
			else {
				return null;
			}
	    }
		
	    public List<Team> findAll(){
			return teamRepo.findAll();
		}
		public Team createTeam(Team event) {
			return teamRepo.save(event);
		}
		
		 public void deleteTeam(Long id) {
		  	   Optional<Team> ex = teamRepo.findById(id);
		         if(ex.isPresent()) {
		        	 teamRepo.deleteById(id);
		         }
		  }
		  
		    
		    
		
		    
		  
}
