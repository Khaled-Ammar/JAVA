package com.khaled.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khaled.Languages.Repository.LangRepository;
import com.khaled.Languages.model.Lang;



@Service
public class langService {
	private final LangRepository langrepository;
	public langService (LangRepository langrepository ) {
		this.langrepository=langrepository;
		
	}
	public List<Lang> findAll(){ 
		return langrepository.findAll();
	}
	public Lang createLanguage(Lang lang) {
		return langrepository.save(lang);
	}
	
	public Lang findLanguage(Long id) {
		Optional<Lang> nlang = langrepository.findById(id);
		if(nlang.isPresent()) {
			return nlang.get();
		}
		else {
			return null;
		}
	}
	public void deleteLanguage(Long id) {
			langrepository.deleteById(id);
		
	} 
	public Lang updateLanguage(Lang lang) {
		return langrepository.save(lang);
	}


	
}
