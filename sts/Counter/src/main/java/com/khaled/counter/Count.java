package com.khaled.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Count {
    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("/counter")
        public String index(HttpSession session){
            if (session.getAttribute("count") == null) {
                session.setAttribute("count", 1);
            }
            else {
                int count = (int)session.getAttribute("count");
                count++;
                session.setAttribute("count", count);
            }
        return "home.jsp";
    }
}