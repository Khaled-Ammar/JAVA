package com.khaled.DisplayDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DisplayController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/time")
	public String time() {
		
		return "time.jsp";
	}
	
	@RequestMapping("/date")
	public String date() {
		
		return "date.jsp";
	}
	


}
