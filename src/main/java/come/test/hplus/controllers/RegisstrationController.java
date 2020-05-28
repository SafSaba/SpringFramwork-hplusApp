package come.test.hplus.controllers;


import come.test.hplus.beans.User;
import come.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class RegisstrationController {


    @Autowired
    private UserRepository userRepository;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true));
    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model) {
        System.out.println("in registration controller");
        System.out.println(user.getDateOfBirth());

        if (result.hasErrors()) {
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}
