//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexControllers {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/")
    public String indexPost(){
        return "index";
    }

}
