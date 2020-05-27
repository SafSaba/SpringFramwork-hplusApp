package come.test.hplus.controllers;


import come.test.hplus.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {



    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login){
        return "login";
    }
}
