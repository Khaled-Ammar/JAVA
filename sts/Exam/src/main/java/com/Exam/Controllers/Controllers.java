package com.Exam.Controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Exam.model.Exam;
import com.Exam.model.Login;
import com.Exam.model.User;
import com.Exam.services.Services;



@Controller
public class Controllers {

	
	@Autowired
    Services services;
   
   @GetMapping("/")
   public String index(Model model) {
   
       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new Login());
       return "login.jsp";
   }
   @GetMapping("/welcome")
   public String welcome(Model model,HttpSession session) {
   	if (session.getAttribute("user_id") != null) {
   	User user = services.findUser((Long) session.getAttribute("user_id"));
   	List<Exam> bk = services.ExamBrrow2(user);
//   	System.out.println(bk);
   	List<Exam> bk2 = services.unborrowedExams(user);
//   	List<Exam> ss = userServ.AllExamNoBorrow(user);
   	List<Exam> Nulls = services.findByBorrowNull();

//   	System.out.println(ss.get(0).getTitle());
       model.addAttribute("newUser", user);
       model.addAttribute("bk", bk);
       model.addAttribute("bk2", bk2);
       model.addAttribute("examnoborrow", Nulls);

       System.out.println(Nulls);
   	model.addAttribute("allexam", services.findAll());

       return "home.jsp";
   	}
   	else {
   		return "redirect:/";
   	}
   }
   
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, 
           BindingResult result, Model model, HttpSession session) {
       
       // TO-DO Later -- call a register method in the service 
       // to do some extra validations and create a new user!
	   services.register(newUser, result);
       
       if(result.hasErrors()) {
           // Be sure to send in the empty LoginUser before 
           // re-rendering the page.
           model.addAttribute("newLogin", new Login());
           return "login.jsp";
       }
       session.setAttribute("user_id", newUser.getId());
     
       // No errors! 
       // TO-DO Later: Store their ID from the DB in session, 
       // in other words, log them in.
   
       return "redirect:/";
   }
   
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") Login newLogin, 
           BindingResult result, Model model, HttpSession session) {
       
       // Add once service is implemented:
        User user = services.login(newLogin, result);
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "login.jsp";
       }
       session.setAttribute("user_id", user.getId());
       
   
       return "redirect:/welcome";
   }
   @GetMapping("/logout")
   public String logout(HttpSession session) {
   	session.invalidate();
   	return "redirect:/";
   	
   }
   //--------------------------------------------------------------------------------------------------------------------
   @GetMapping("/exam")
   public String addexam(HttpSession session,@ModelAttribute("exam") Exam exam,Model model) {
       model.addAttribute("newLogin", new Exam());
//   	User user = userServ.findUser((Long) session.getAttribute("user_id"));
       model.addAttribute("user",services.findUser((Long) session.getAttribute("user_id")));
   	return "createexam.jsp";
   	
   }
   @PostMapping("/newexam")
   public String createExam(@Valid @ModelAttribute("exam") Exam exam ,BindingResult result ,Model model,HttpSession session) {
       if (result.hasErrors()) {
           return "createexam.jsp";
       } else {
       
    	   services.createExam(exam);
           return "redirect:/welcome";
       }
   }
   @RequestMapping("/getexam/{id}")
   public String allexams(@PathVariable("id") Long id,Model model) {
   	
   	model.addAttribute("allexam", services.findExam(id));
   	System.out.println(services.findExam(id));
   	return "showexam.jsp";
   }
   
   @GetMapping("edit/getexam/{id}")
	 public String edit(@PathVariable("id")Long id,Model model) {
		 Exam exam = services.findExam(id);
		 model.addAttribute("exam", exam);
		 return "Editexam.jsp";
	 }
   @PutMapping("edit/getexam/{id}")
	 public String update(@Valid @ModelAttribute("exam") Exam exam,BindingResult result) {
		   if (result.hasErrors()) {
	            return "Editexam.jsp";
	            }
		   else {
			   services.createExam(exam);
			   return "redirect:/welcome";
		   }
		 
	 }
   @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
	   services.deleteExam(id);
	return "redirect:/welcome";
	 }
//   @GetMapping("/addborrow/{id}")
//   public String ExamBorrow(Model model,HttpSession session,@PathVariable("id") Long id) {
//           return "redirect:/welcome";
//       
//   }
   @RequestMapping("/addborrow/{examId}")
   public String createExamBorrow(@PathVariable("examId") Long examId,HttpSession session) {
   		Exam exam = services.findExam(examId);
   		User user = services.findUser((Long)session.getAttribute("user_id"));
//   		user.getExam().add(exam);
//   		userServ.createExam(exam);
   		services.addBorrower(exam, user);
           return "redirect:/welcome";
       
   }
   
   @RequestMapping("/Removeborrow/{examId}")
   public String removeExamBorrow(@PathVariable("examId") Long examId,HttpSession session) {
   		Exam exam = services.findExam(examId);
   		User user = services.findUser((Long)session.getAttribute("user_id"));
//   		user.getExam().add(exam);
//   		userServ.createExam(exam);
   		services.deleteBorrower(exam, user);
           return "redirect:/welcome";
       
   }
   
   
   
}