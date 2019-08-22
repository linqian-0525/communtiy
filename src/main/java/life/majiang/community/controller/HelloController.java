package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 2019/8/22 by Lin
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
