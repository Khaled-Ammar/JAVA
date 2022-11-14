package com.khaled.SaveTravels.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khaled.SaveTravels.Repository.TravelsRepository;
import com.khaled.SaveTravels.model.Travelsmodel;
@Service
public class TravelsService {
	private final TravelsRepository travelsrepository;
	
	public TravelsService(TravelsRepository travelsrepository) {
		this.travelsrepository = travelsrepository ;
	}
		
	
    public List<Travelsmodel> allTravels() { 
        return travelsrepository.findAll();
    }
// 
    // creates a Travel
    public Travelsmodel createtravel(Travelsmodel t) {
        return travelsrepository.save(t);
    }
    
    public void deletetravel(Long id) {
    	   Optional<Travelsmodel> optionalTravel = travelsrepository.findById(id);
           if(optionalTravel.isPresent()) {
        	   travelsrepository.deleteById(id);
           }
    }
    
    
    
	public Travelsmodel updateTravels(Travelsmodel t) {
		return travelsrepository.save(t);
	}
    // retrieves a Travel
    public Travelsmodel findtravel(Long id) {
        Optional<Travelsmodel> optionaltravel = travelsrepository.findById (id);
        if(optionaltravel.isPresent()) {
            return optionaltravel.get();
        } 
        else {
            return null;
        }
    }
}



