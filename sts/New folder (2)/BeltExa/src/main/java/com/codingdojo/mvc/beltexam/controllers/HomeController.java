package com.codingdojo.mvc.beltexam.controllers;

import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.mvc.beltexam.models.LoginUser;
import com.codingdojo.mvc.beltexam.models.Trip;
import com.codingdojo.mvc.beltexam.models.User;
import com.codingdojo.mvc.beltexam.models.usertrips;
import com.codingdojo.mvc.beltexam.repositries.usertripRepo;
import com.codingdojo.mvc.beltexam.services.TripServ;
import com.codingdojo.mvc.beltexam.services.UserServ;
import com.codingdojo.mvc.beltexam.services.usertripServ;









@Controller
public class HomeController {
    
    // Add once service is implemented:
	 @Autowired
     UserServ userServ;
	 @Autowired
	TripServ tripServ;
	 @Autowired
	 usertripServ usertripserv;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
      
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
        return "redirect:/";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
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
    ///////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/dashboard")
    public String home(Model model,HttpSession session) {
        model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
        model.addAttribute("trips",tripServ.findAll());

    	return "dashboard.jsp";
    }
    
    
    
    @GetMapping("/trip")
    public String addtrip(HttpSession session,@ModelAttribute("trip")Trip Trip,Model model) {
        model.addAttribute("newLogin", "newtrip()");
        model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
    	return "createtrip.jsp";
    	
    }
    @PostMapping("/newtrip")
    public String createtrip(@Valid @ModelAttribute("trip")Trip trip ,BindingResult result ,Model model,HttpSession session) {
		User user = userServ.findUser((Long)session.getAttribute("user_id"));

        if (result.hasErrors()) {
            return "createtrip.jsp";
        } else {
        	
        	tripServ.createTrip(trip);
       System.out.println(trip.getTitel());
            return "redirect:/dashboard";
        }
    }
    
    @GetMapping("/show/trip/{id}")
  	 public String showOnetrip(@PathVariable("id")Long id,Model model,HttpSession session,RedirectAttributes redirectAttributes) {
  		Trip trip =tripServ.findTrip(id);
  		 User user =userServ.findUser((Long)session.getAttribute("user_id"));
  		 model.addAttribute("trip",trip);
  		 model.addAttribute("user", userServ.findUser((Long)session.getAttribute("user_id")));
  		
  		model.addAttribute("usertrip", usertripserv.findAll());
  		 model.addAttribute("users", userServ.findAll());
  		 
//  		 model.addAttribute("usersnot", userServ.userNot(trip));
  		 
  		 if(trip.getUsers().size()> trip.getCapacity()) {
  			redirectAttributes.addFlashAttribute("error", "TheTrip Is Full!");
  		 }

  		 return "showtrip.jsp";
  	 }
    @PostMapping("/tripadd/{id}")
    public String createnew(@PathVariable("id") Long id, @RequestParam(value="userid") Long userid,  Model model,RedirectAttributes redirectAttributes) {
       Trip trip =tripServ.findTrip(id);
        User user = userServ.findUser(userid);
		 
 		 if(trip.getUsers().size() > trip.getCapacity()) {
 			redirectAttributes.addFlashAttribute("error", "TheTrip Is Full!");
 		 }
 		 else {
 		trip.getUsers().add(user);
        tripServ.createTrip(trip);
     	
          }
 		return "redirect:/show/trip/"+id;
        
	}
    @GetMapping("edit/trip/{id}")
	 public String edittrip(@PathVariable("id")Long id,Model model) {
		Trip trip =tripServ.findTrip(id);
		 model.addAttribute("trip",trip);
		 
		 return "Edittript.jsp";
	 }
    @PutMapping("edit/trip/{id}")
	 public String updatetrip(@Valid @ModelAttribute("trip")Trip trip,BindingResult result,HttpSession session , Model model) {
		   if (result.hasErrors()) {
	            return "Edittript.jsp";
	            }
		   else {
			   Trip trip1=tripServ.findTrip(trip.getId());
			   List <User> g=trip1.getUsers();
			   trip.setUsers(g);
			  tripServ.createTrip(trip);
			  model.addAttribute("user",userServ.findUser((Long) session.getAttribute("user_id")));
		        model.addAttribute("trips",tripServ.findAll());
   	
			   return "redirect:/dashboard";
		   }
		 
	 }
    @RequestMapping("/delete/trip/{id}")
    public String deletetrip(@PathVariable("id") Long id,HttpSession session) {
    	Trip trip =tripServ.findTrip(id);
    	tripServ.deleteTrip(trip.getId());

        return "redirect:/dashboard";
    }
        
        
        
//        @RequestMapping("/goin")
//        public String showOnetrip1(@PathVariable("id")Long id,Model model,HttpSession session,RedirectAttributes redirectAttributes) {
//     		TripTrip =TripServ.findtrip(id);
//     		 User user =userServ.findUser((Long)session.getAttribute("user_id"));
//     		 model.addAttribute("trip",Trip);
//     		 model.addAttribute("user", userServ.findUser((Long)session.getAttribute("user_id")));
//     		 model.addAttribute("users", userServ.findAll());
//     		 model.addAttribute("usersnot", userServ.userNot(trip));
//     		 
//     		 if(trip.getUsers().size()>30) {
//     			redirectAttributes.addFlashAttribute("error", "TheTrip Is Full!");
//     		 }
//       
//            return "redirect:/showtrip";
//            
//        
//    }
        
        
//        @RequestMapping("/jointrip/{projectId}")
//        public String jointrip(@PathVariable("id") Long projectId,HttpSession session) {
//        		trip project = userServ.findtrip(id);
//        		User user = userServ.findUser((Long)session.getAttribute("user_id"));
//        		user.getCreatName().add(project);
//        		userServ.CreatName(project);
//
//                return "redirect:/dashboard";
//            
//        }
//        
//        @RequestMapping("/Leavetrip/{id}")
//        public String leavetrip(@PathVariable("id") Long projectId,HttpSession session) {
//        		trip project = userServ.findtrip(id);
//        		User user = userServ.findUser((Long)session.getAttribute("user_id"));
//        		user.getCreatName().remove(project);
//        		userServ.CreatName(project);
//
//                return "redirect:/dashboard";
//            
//        }
    
    
    
//    
    
//    @RequestMapping("/delete/trip/{id}")
//    public String deleteTrip(@PathVariable("id") Long id,HttpSession session) {
//    		Trip trip = tripServ.findTrip(id);
//    		tripServ.deleteProject(trip.getId());
//
//            return "redirect:/dashboard";
//        
//    }
//    @GetMapping("edit/trip/{id}")
// 	 public String editTrip(@PathVariable("id")Long id,Model model) {
// 		 Trip trip = tripServ.findTrip(id);
// 		 model.addAttribute("trip", trip);
// 		 return "Edittrip.jsp";
// 	 }
//     @PutMapping("edit/trip/{id}")
// 	 public String updateTrip(@Valid @ModelAttribute("trip") Trip trip,BindingResult result,HttpSession session) {
// 		   if (result.hasErrors()) {
// 	            return "Edittrip.jsp";
// 	            }
// 		   else {
// 			 tripServ.createProject(trip);
//// 			 User user = userServ.findUser((Long)session.getAttribute("user_id"));
//// 			user.getProjects().add(project);
////    		userServ.createProject(project);
//    	
// 			   return "redirect:/dashboard";
// 		   }
// 		 
// 	 }
    @RequestMapping("/join/trip/{id}")
    public String joinEvent(@PathVariable("id") Long id,HttpSession session) {
    		Trip trip = tripServ.findTrip(id);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    		
    		
    		user.getTrips().add(trip);
//   		System.out.println(user.getEvents().contains(event));
    		
    		tripServ.createProject(trip);
//    		usertrips t =usertripserv.findDate(user);
//    		Date date=new Date();
//    		t.setCreatedAt(user.getCreatedAt());
//    		System.out.println(t.getUser().getId());
//    		tripServ.createProject(trip);
//    		usertripserv.create(t);
            return "redirect:/dashboard";
        
    }
    @RequestMapping("/leavetrip/{id}")
    public String leaveEvent(@PathVariable("id") Long id,HttpSession session) {
    		Trip event = tripServ.findTrip(id);
    		User user = userServ.findUser((Long)session.getAttribute("user_id"));
    		user.getTrips().remove(event);
    		tripServ.createProject(event);

            return "redirect:/dashboard";
    }    
}
