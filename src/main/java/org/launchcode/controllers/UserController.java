package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model){
        model.addAttribute("user", new User());
        return "user/add";
    }

//    @PostMapping
//    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
//// add form submission handling code here
//
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//
//        if(user.getPassword().equals(verify)){
//            return "user/index";
//        }else{
//            model.addAttribute("error", "Your password doesn't match");
//            return "user/add";
//        }
//    }

    @PostMapping("/add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model, String verify) {
        if (errors.hasErrors()) {
            model.addAttribute(errors);
            return "user/add";
        }
        return "user/index";
    }

    @GetMapping()
    public String renderUserPage() {
        return "user/index";
    }
}

