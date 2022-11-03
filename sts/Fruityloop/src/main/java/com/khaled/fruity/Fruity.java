package com.khaled.fruity;



import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Fruity {
	@RequestMapping("/")
	public String index(Model model) {

		ArrayList<Item> fruity = new ArrayList<Item>();
		fruity.add(new Item("Kiwi", 1.5));
		fruity.add(new Item("Mango", 2.0));
		fruity.add(new Item("Goji Berries", 4.0));
		fruity.add(new Item("Guava", .75));
		model.addAttribute("fruity1", fruity);
		return "index.jsp";

	}
}

