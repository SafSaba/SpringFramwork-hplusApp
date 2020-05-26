package come.test.hplus.controllers;


import come.test.hplus.beans.User;
import come.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisstrationController {


        @Autowired
        private UserRepository userRepository;

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("newuser") User user, Model model){
        System.out.println("in registration controller");
        userRepository.save(user);
        model.addAttribute("dataSaved","User registered successfully");
        return "login";
    }
}
