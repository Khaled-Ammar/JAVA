package com.codingdojo.DaikichiRoutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DaikichiRoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiRoutesApplication.class, args);
	}

	// ...
	// ...
	@RestController
	@RequestMapping("/greeting")
	public class HomeController {
	    @RequestMapping("")
	    public String index(){
	      return "welcome!";
	    }
	    @RequestMapping("/today")
	    public String hello(){
	      return "!endeavors your all in luck find will you Today";
	    }
	    @RequestMapping("/tomorrow")
	    public String world(){
	      return "!ideas new to open be to sure be SO ,arise will opportunity an ,Tomorrow";
	    }
	}


	}



