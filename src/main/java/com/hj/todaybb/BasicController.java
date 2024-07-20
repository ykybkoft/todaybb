package com.hj.todaybb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    @GetMapping("/")
    String home(){
        return "home.html";
    };
}
