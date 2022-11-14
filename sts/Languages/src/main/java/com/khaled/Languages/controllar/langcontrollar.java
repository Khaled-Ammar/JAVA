package com.khaled.Languages.controllar;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.khaled.Languages.model.Lang;
import com.khaled.Languages.services.langService;

@Controller
public class langcontrollar {
	private final langService langService;
	public langcontrollar(langService langService) {
	this.langService=langService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	@GetMapping("/languages")
	public String languages(@ModelAttribute ("language") Lang lang, Model model){
			List<Lang> allLanguages = langService.findAll();
			model.addAttribute("lang", allLanguages);
			return "lang.jsp";
	}
	 @PostMapping("/addlangugae")
	    public String create(@Valid @ModelAttribute("language") Lang lang ,BindingResult result ,Model model) {
	        if (result.hasErrors()) {
	        	List<Lang> allLanguages = langService.findAll();
	    		model.addAttribute("lang", allLanguages);
	            return "lang.jsp";
	        } else {
	        	langService.createLanguage(lang);
	            return "redirect:/languages";
	        }
	    }
	 @GetMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 langService.deleteLanguage(id);
		 return "redirect:/languages";
	 }
	 @GetMapping("/lang/{id}")
	 public String showSingle(@PathVariable("id")Long id,Model model) {
		 Lang lang = langService.findLanguage(id);
		 model.addAttribute("language", lang);
		 return "Show.jsp";
	 }
	 @GetMapping("/edit/{id}")
	 public String edit(@PathVariable("id")Long id,Model model) {
		 List<Lang> allLanguages = langService.findAll();
		 model.addAttribute("lang", allLanguages);
		 Lang lang = langService.findLanguage(id);
		 model.addAttribute("language", lang);
		 return "edit.jsp";
	 }
	 @PostMapping("/edit/{id}")
	 public String update(@Valid @ModelAttribute("language") Lang lang,BindingResult result) {
		   if (result.hasErrors()) {
	            return "edit.jsp";
	            }
		   else {
			   langService.updateLanguage(lang);
			   return "redirect:/";
		   }
		 
	 }
	
}
