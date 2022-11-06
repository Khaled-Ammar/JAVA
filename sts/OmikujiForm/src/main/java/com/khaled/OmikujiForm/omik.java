package com.khaled.OmikujiForm;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class omik {
    @RequestMapping("/")
    public String home(){
        return "index.jsp";
    }

@PostMapping( "/handle")
    public String handle(@RequestParam(value="number") String number,
                       @RequestParam(value="city") String city,
                       @RequestParam(value="realPerson") String realPerson,
                       @RequestParam(value="endeavor") String endeavor,
                       @RequestParam(value = "livingThing") String livingThing,
                       @RequestParam(value="smthNice")String smthNice,
                       HttpSession session) {
    session.setAttribute("number", number);
    session.setAttribute("city", city);
    session.setAttribute("realPerson", realPerson);
    session.setAttribute("endeavor", endeavor);
    session.setAttribute("livingThing", livingThing);
    session.setAttribute("smthNice", smthNice);

    return "redirect:/result";
}
    @RequestMapping("/result")
    public String result(){
        return "omi.jsp";
    }
}
