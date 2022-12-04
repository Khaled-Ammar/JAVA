package com.example.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Service.Serveses;
import com.example.model.Login;
import com.example.model.User;


@Controller
public class Controllers {
	 @Autowired
	public final Serveses userServ;
	
	
	 public Controllers(Serveses userServes) {
		
		this.userServ = userServes;
	}
	 @GetMapping("/")
	    public String index(Model model) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new Login());
	        return "login.jsp";
	    }
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	    	userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	            model.addAttribute("newLogin", new Login());
	            return "login.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/";
	    }

	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") Login newLogin, 
	            BindingResult result, Model model, HttpSession session) {

	        // Add once service is implemented:
	         User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/dashboard";
	    }
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";

	    }
}