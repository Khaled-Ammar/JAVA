package com.PAC.Controllar;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PAC.Service.Services;
import com.PAC.model.Categorie;
import com.PAC.model.Product;

@Controller
public class Controllers {
	private final Services services;
	public Controllers (Services services) {
		this.services=services;
	}
	
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String index(Model model) {
			model.addAttribute("product",services.findAll());
			model.addAttribute("cat",services.findNinja());

			return "Home.jsp";
	}
	@GetMapping("/products")
	public String addproduct(@ModelAttribute ("product") Product product,Model model) {
			return "newproduct.jsp";
	}
	@PostMapping("/add")
    public String create(@Valid @ModelAttribute("product") Product product ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "newproduct.jsp";
        } else {
        	services.createLookify(product);
            return "redirect:/products";
        }
    }
	@GetMapping("/cat")
	public String addcat(@ModelAttribute ("categorie") Categorie categorie,Model model) {
			return "newcat.jsp";
	}
	@PostMapping("/addcat")
    public String create(@Valid @ModelAttribute("categorie") Categorie categorie ,BindingResult result ,Model model) {
        if (result.hasErrors()) {
            return "newcat.jsp";
        } else {
        	services.createNinja(categorie);
            return "redirect:/cat";
        }
    }
	 @GetMapping("/product/{productId}")
	    public String show2(@PathVariable("productId") Long id,Model model){
	    	model.addAttribute("show",services.findLookify(id));
	    	 Product product = services.findLookify(id);
	    	model.addAttribute("allcat",services.allproductbycat(product));
	        
	    	model.addAttribute("procat",services.proCat(product));
	    	

	    	
	    	return "showproduct.jsp";
	    }
	 @PostMapping("/product/{id}")
	    public String createnew(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
	        Product product = services.findLookify(id);
	        Categorie category = services.findCat(catId);
	    	product.getCategories().add(category);
	    	services.updateProduct(product);
	    	Long ids=id;
	        return "redirect:/product/"+ids;   
		}
	 
	 
	 /////////////////////product//////////////////
	 
	 
	 @GetMapping("/cat/{catid}")
	    public String showcat(@PathVariable("catid") Long id,Model model){
	    	model.addAttribute("show",services.findCat(id));
	        Categorie category = services.findCat(id);

	    	model.addAttribute("allprodu",services.ProductNitcontains(category));
	    	model.addAttribute("procat",services.catPro(category));
	    	return "showcat.jsp";
	    }
	 @PostMapping("/cat/{id}")
	    public String createprod(@PathVariable("id") Long id, @RequestParam(value="productid") Long catId,  Model model) {
	        Product product = services.findLookify(catId);
	        Categorie category = services.findCat(id);
	    	category.getProducts().add(product);
	    	services.updateCat(category);
	    	Long ids=id;
	        return "redirect:/cat/"+ids;   
		}
	   
}
