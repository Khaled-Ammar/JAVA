package com.DojoandNinjas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DojoandNinjas.Repository.DojoRepository;
import com.DojoandNinjas.Repository.NinjaRepository;
import com.DojoandNinjas.model.Dojo;
import com.DojoandNinjas.model.Ninja;

@Service
public class DojoNinjaService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		super();
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Dojo> findAll(){ 
		return dojoRepo.findAll();
	}
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> ndojo = dojoRepo.findById(id);
		if(ndojo.isPresent()) {
			return ndojo.get();
		}
		else {
			return null;
		}
	}
//	public void deleteDojo(Dojo id) {
//		dojoRepo.deleteById(id);
//		
//	} 
//	public Dojo updateDojo(Dojo dojo) {
//		return dojoRepo.save(dojo);
//	}
	
	
	
	
	
//	public List<Ninja> findAll(){ 
//		return ninjaRepo.findAll();
//	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> nninja = ninjaRepo.findById(id);
		if(nninja.isPresent()) {
			return nninja.get();
		}
		else {
			return null;
		}
	}
//	public void deleteNinja(Ninja id) {
//		ninjaRepo.deleteById(id);
//		
//	} 
//	public Dojo updateNinja(Ninja ninja) {
//		return ninjaRepo.save(ninja);
//	}


	
		
}
