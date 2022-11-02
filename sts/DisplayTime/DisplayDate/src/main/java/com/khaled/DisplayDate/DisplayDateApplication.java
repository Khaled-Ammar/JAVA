package com.khaled.DisplayDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.util.Calendar;

@SpringBootApplication
@Controller
public class DisplayDateApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        int time = GfG ;

    
     class GfG {
     	
     	public void main(String[] args)
     	{

     	
     		Calendar c1 = Calendar.getInstance();

     		c1.set(Calendar.MONTH, 11);

     		
     		c1.set(Calendar.DATE, 05);

     		c1.set(Calendar.YEAR, 2000);

     		Date dateOne = c1.getTime();

     		System.out.println("Date: " + dateOne);

     		System.out.println(dateOne.getTime());
     	}
     }
     
     model.addAttribute("time", time) ;

    
    	
    
        return "index.jsp";
    }
    


}
