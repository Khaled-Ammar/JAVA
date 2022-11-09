package com.khaled.SaveTravels.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.khaled.SaveTravels.Service.TravelsService;
import com.khaled.SaveTravels.model.Travelsmodel;

@Controller
public class Travels {
	private final TravelsService travelsservice ;
	
	public Travels (TravelsService travelsservice) {
		this.travelsservice = travelsservice;
	}

	@GetMapping("/")
	public String index() {

		return "redirect:/show";
	}
	
	
	
	@GetMapping("/show")
	public String travel(@ModelAttribute("travel") Travels travel, Model model) {
		List<Travelsmodel> t = travelsservice.allTravels();
		model.addAttribute("tr", t);
		return "index.jsp";
	}
	
	@PostMapping("/go")
	public String create(@Valid @ModelAttribute("travel") Travelsmodel travel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Travelsmodel> t = travelsservice.allTravels();
			model.addAttribute("tr", t);
			return "index.jsp";
		} else {
			travelsservice.createtravel (travel);
			return "redirect:/show";
		}
	}
	@GetMapping("/tr/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Travelsmodel travel = travelsservice.findtravel(id);
		model.addAttribute("travel", travel);
		return "Show.jsp";
	}
	
	
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("travel") Travelsmodel travel, BindingResult result) {
		if (result.hasErrors()) {
			return "Show.jsp";
		} else {
			travelsservice.updateTravels (travel);
			return "redirect:/";
		}

	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		travelsservice.deletetravel(id);
		return "redirect:/";
	}
	
	@GetMapping("/trave/{id}")
	public String showSingle(@PathVariable("id") Long id, Model model) {
		Travelsmodel travel = travelsservice.findtravel(id);
		model.addAttribute("travel", travel);
		return "travel.jsp";
	}

	
}
