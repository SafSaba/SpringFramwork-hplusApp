package come.test.hplus.controllers;


import come.test.hplus.beans.Login;
import come.test.hplus.beans.User;
import come.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login){
      User user = userRepository.searchByName(login.getUsername());

        return "login";
    }
}
