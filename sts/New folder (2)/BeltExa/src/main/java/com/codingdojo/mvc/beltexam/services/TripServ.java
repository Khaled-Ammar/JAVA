package com.codingdojo.mvc.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.beltexam.models.Trip;
import com.codingdojo.mvc.beltexam.repositries.TripRepo;


@Service
public class TripServ {
	@Autowired
	TripRepo tripRepo;

	 public Trip findTrip(Long id) {
			Optional<Trip> trip = tripRepo.findById(id);
			if(trip.isPresent()) {
				return trip.get();
			}
			else {
				return null;
			}
	    }
		
	    public List<Trip> findAll(){
			return tripRepo.findAll();
		}
		public Trip createTrip(Trip Trip) {
			return tripRepo.save(Trip);
		}
		
		 public void deleteTrip(Long id) {
		  	   Optional<Trip> ex = tripRepo.findById(id);
		         if(ex.isPresent()) {
		        	 tripRepo.deleteById(id);
		         }
		  }
		  
		    
		 public Trip createProject(Trip trip) {
				return tripRepo.save(trip);
			}
			
			 public void deleteProject(Long id) {
			  	   Optional<Trip> ex = tripRepo.findById(id);
			         if(ex.isPresent()) {
			        	 tripRepo.deleteById(id);
			         }
		
		    
		  
			 }
			 }
