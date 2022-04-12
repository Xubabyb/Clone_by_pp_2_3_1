package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class ShowController {

    @GetMapping("/hello")
    public String hello(){
        return "show/hello";
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "show/goodbye";
    }
}
