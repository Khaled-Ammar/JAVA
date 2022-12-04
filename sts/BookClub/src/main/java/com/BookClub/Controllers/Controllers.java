package com.BookClub.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookClub.Serveses.Serveses;
import com.BookClub.model.Book;
import com.BookClub.model.Login;
import com.BookClub.model.User;



@Controller
//@Autowired
public class Controllers {
	 @Autowired
	private final Serveses userServ;
	

	public Controllers(Serveses userServ) {
		super();
		this.userServ = userServ;
	}
	@GetMapping("/home")
  public String home(Model model, HttpSession session) {
      if (session.getAttribute("user_id") != null) {
      Long user_id = (Long) session.getAttribute("user_id");
      User thisUser = userServ.findUserById(user_id);
      model.addAttribute("thisUser", thisUser);
      model.addAttribute("allbook",userServ.allbook());
      User user = userServ.findUserById((Long) session.getAttribute("user_id"));
      model.addAttribute("user",user);
      return "ShowAll.jsp";
  }
      else {
          return "redirect:/";
      }
  }
			    @GetMapping("/")
			    public String index(Model model,HttpSession session) {
			        model.addAttribute("newUser", new User());
			        model.addAttribute("newLogin", new Login());
//			        User user =userServ.findUserById((Long)session.getAttribute("user_id"));
//			    	model.addAttribute("allbook",userServ.findbyUserNotContain(user));
//			    	System.out.println(userServ.findbyUserNotContain(user));
			        return "index.jsp";
			    }
			    
			    @PostMapping("/register")
			    public String register(@Valid @ModelAttribute("newUser") User newUser, 
			            BindingResult result, Model model, HttpSession session) {
			        userServ.register(newUser, result);
			        if(result.hasErrors()) {
			            model.addAttribute("newLogin", new Login());
			            return "index.jsp";
			        }
			        session.setAttribute("user_id", newUser.getId());
			        return "redirect:/home";
			    }
			    
			    @PostMapping("/login")
			    public String login(@Valid @ModelAttribute("newLogin") Login newLogin, 
			            BindingResult result, Model model, HttpSession session) {
			        User user = userServ.login(newLogin, result);
			        
			        if(result.hasErrors()) {
			            model.addAttribute("newUser", new User());
			            return "index.jsp";
			        }
			        session.setAttribute("user_id", user.getId());
			        return "redirect:/home";
			    }
			    @GetMapping("/logout")
			    public String logout(HttpSession session) { 
			            session.invalidate();
			            return "redirect:/";

			    }
			    @GetMapping("/book")
			    public String addbook(HttpSession session,@ModelAttribute("book") Book book,Model model) {
			        model.addAttribute("newLogin", new Book());
//			        User user = userServ.findUser((Long) session.getAttribute("user_id"));
			        model.addAttribute("user",session.getAttribute("user_id"));
			        return "login.jsp";

			    }
			    @PostMapping("/newbook")
			    public String createBook(@Valid @ModelAttribute("book") Book book ,BindingResult result ,Model model,HttpSession session) {
			        if (result.hasErrors()) {
			            return "login.jsp";
			        } else {

			             userServ.createbook(book);
			            return "redirect:/home";
			        }
			    }
			    @RequestMapping("/show/{id}")
			    public String Show(Model model,HttpSession session,@PathVariable("id")Long id ) {
			    	Book book =userServ.findBookById(id);
			        model.addAttribute("book",book);
			        User user =userServ.findUserById((Long)session.getAttribute("user_id"));
			        model.addAttribute("user",user);
			    	return "show.jsp";
			    }
			    //==-=========-=-=-=-=--------------------------------====================----------
			    @RequestMapping("/update/{id}")
			    public String edit(@Valid @ModelAttribute("updatebook") Book book ,BindingResult result ,Model model,HttpSession session,@PathVariable("id")Long id ) {
//			    	
			    	model.addAttribute("book",userServ.findBookById(id));
//			    	User user =userServ.findUserById((Long)session.getAttribute("user_id"));
//			    	model.addAttribute("user",user);
			    	return "update.jsp";
			    }
			    
			    
			    @PutMapping("/edit/{id}")
			    public String createBooke(@Valid @ModelAttribute("updatebook") Book book ,BindingResult result ,Model model,HttpSession session) {
			        if (result.hasErrors()) {
			            return "update.jsp";
			        } else {
			        	
			             userServ.updatebook(book);
			            return "redirect:/home";
			        }
			    }
			    //--------------------------------------------------------------------------------
			    @RequestMapping("/delete/{id}")
			    public String delete(@Valid @ModelAttribute("updatebook") Book book ,BindingResult result ,Model model,HttpSession session,@PathVariable("id")Long id ) {
				   	
			    	
			    	userServ.delete(id);
//			    	User user =userServ.findUserById((Long)session.getAttribute("user_id"));
//			    	model.addAttribute("user",user);
			    	return "redirect:/home";
			    }
			   //--------------------------------------------------------------------------------- 
			    @GetMapping("/market")
			    public String bookmarket(Model model, HttpSession session) {
			    	User user =userServ.findUserById((Long)session.getAttribute("user_id"));
			    	model.addAttribute("allbook",userServ.allbook());
			    	model.addAttribute("user",user);
			    	
			    	return "market.jsp";
			    }
			    
			    //=------------------------=====================================------------------=
			    
			    @RequestMapping("/borrow/{id}")
			    public String bookborrw(Model model, HttpSession session,@PathVariable("id")Long id) {
			    	Book b=userServ.findBookById(id);
			    	b.setParow(true);
			    	User user =userServ.findUserById((Long)session.getAttribute("user_id"));
			    	b.setUserprow(user);
			    	
			    	userServ.updatebook(b);
			    	model.addAttribute("allbook",userServ.allbook());
			    	
			    	
			    	return "redirect:/market";
			    }
			    @RequestMapping("/return/{id}")
			    public String bookreturn(Model model, HttpSession session,@PathVariable("id")Long id) {
			    	Book b=userServ.findBookById(id);
			    	b.setParow(false);
			    	User user =userServ.findUserById((Long)session.getAttribute("user_id"));
			    	b.setUserprow(null);
			    	
			    	userServ.updatebook(b);
			    	model.addAttribute("allbook",userServ.allbook());
			    	model.addAttribute("user",user);
			    	
			    	
			    	return "redirect:/market";
			    }
			    
			    
			    
			    
			    
			    
			    
			
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
//			     Add once service is implemented:
			    
//			     private UserService userServ;
			    
//			    @GetMapping("/")
//			    public String index(Model model) {
//			    
//			        // Bind empty User and LoginUser objects to the JSP
//			        // to capture the form input
//			        model.addAttribute("newUser", new User());
//			        model.addAttribute("newLogin", new LoginUser());
//			        return "index.jsp";
//			    }
			    
//			    @PostMapping("/register")
//			    public String register(@Valid @ModelAttribute("newUser") User newUser, 
//			            BindingResult result, Model model, HttpSession session) {
//			        
//			        // TO-DO Later -- call a register method in the service 
//			        // to do some extra validations and create a new user!
//			        
//			        if(result.hasErrors()) {
//			            // Be sure to send in the empty LoginUser before 
//			            // re-rendering the page.
//			            model.addAttribute("newLogin", new LoginUser());
//			            return "index.jsp";
//			        }
//			        
			        // No errors! 
			        // TO-DO Later: Store their ID from the DB in session, 
			        // in other words, log them in.
			    
//			        return "redirect:/home";
//			    }
			    
//			    @PostMapping("/login")
//			    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
//			            BindingResult result, Model model, HttpSession session) {
//			        
//			        // Add once service is implemented:
//			        // User user = userServ.login(newLogin, result);
//			    
//			        if(result.hasErrors()) {
//			            model.addAttribute("newUser", new User());
//			            return "index.jsp";
//			        }
//			    
//			        // No errors! 
//			        // TO-DO Later: Store their ID from the DB in session, 
//			        // in other words, log them in.
//			    
//			        return "redirect:/home";
//			    }
			    
			

			
	
	
}

