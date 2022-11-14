package com.DojoandNinjas.controllar;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.DojoandNinjas.Service.DojoNinjaService;
import com.DojoandNinjas.model.Dojo;
import com.DojoandNinjas.model.Ninja;

@Controller
public class DojoNinjacontrollar {
	
		private final DojoNinjaService dojoninjaService;

		public DojoNinjacontrollar(DojoNinjaService dojoninjaService) {
			
			this.dojoninjaService = dojoninjaService;
		}

		@GetMapping("/")
		public String home() {
			return "redirect:/dojos";
}
		@GetMapping("/dojos")
		public String adddojo(@ModelAttribute ("dojo") Dojo dojo,Model model) {
				return "adddojo.jsp";
}
		
		@PostMapping("/add")
	    public String create(@Valid @ModelAttribute("dojo") Dojo dojo ,BindingResult result ,Model model) {
	        if (result.hasErrors()) {
	            return "adddojo.jsp";
	        } else {
	        	dojoninjaService.createDojo(dojo);
	            return "redirect:/dojos";
	        }
}
		@GetMapping("/ninjas")
		public String addninja(@ModelAttribute ("ninja") Ninja ninja,Model model) {
				model.addAttribute("alldojos",dojoninjaService.findAll());
				return "addninja.jsp";
		}
		
		@PostMapping("/newninja")
	    public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja ,BindingResult result ,Model model) {
	        if (result.hasErrors()) {
	            return "adddojo.jsp";
	        } else {
	        	dojoninjaService.createNinja(ninja);
	            return "redirect:/ninjas";
	        }

}
		
		@GetMapping("/dojos/{id}")
	    public String show2(@PathVariable("id") Long id,Model model){
	    	model.addAttribute("show",dojoninjaService.findDojo(id));

	    	return "show.jsp";
	    }
}

