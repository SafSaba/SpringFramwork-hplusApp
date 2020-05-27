package come.test.hplus.controllers;


import come.test.hplus.beans.Login;
import come.test.hplus.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public User getDefaultUser(){
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){
        return Arrays.asList(new String[]{"Male","Female","Other"}); }

    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }

}
